package org.sopt.careerly_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.sopt.careerly_android.domain.PostRepository
import org.sopt.careerly_android.ui.home.PostsData
import org.sopt.careerly_android.ui.home.ProfileData
import org.sopt.careerly_android.ui.viewmodel.MainViewModel.Companion.EXAMPLE_PROFILE_IMAGE
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    private val _postsData = MutableLiveData<List<PostsData>>()
    val postsData: LiveData<List<PostsData>>
        get() = _postsData

    private val _profileData = MutableLiveData<List<ProfileData>>()
    val profileData: LiveData<List<ProfileData>>
        get() = _profileData

    fun getProfileData() {
        viewModelScope.launch {
            postRepository.getPostList(

            ).onSuccess {
                val data = it.hotProfiles.map {
                    ProfileData(
                        it.followers,
                        it.job,
                        it.userName
                    )
                }
                _profileData.value = data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun getPostList() {
        viewModelScope.launch {
            postRepository.getPostList(
            ).onSuccess {
                val data = it.posts.map {
                    PostsData(
                        it.createdAt,
                        it.likes,
                        it.text,
                        it.userEmail,
                        it.userName,
                        it.userImg,
                        it.postId,
                        it.views
                    )
                }
                _postsData.value = data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
