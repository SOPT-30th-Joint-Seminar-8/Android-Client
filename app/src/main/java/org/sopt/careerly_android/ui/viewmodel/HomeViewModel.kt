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
    val postsData = MutableLiveData<List<PostsData>>()
    val profileData = MutableLiveData<List<ProfileData>>()

    fun getProfileData() {
        viewModelScope.launch {
            postRepository.getPostList(

            ).onSuccess {
                val data = mutableListOf<ProfileData>()
                for (i in 0 until it.hotProfiles.size) {
                    val item = it.hotProfiles[i]
                    data.add(
                        ProfileData(
                            item.followers,
                            item.job,
                            item.userName
                        )
                    )
                }
                profileData.value = data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun getPostList() {
        viewModelScope.launch {
            postRepository.getPostList(
            ).onSuccess {
                val data = mutableListOf<PostsData>()
                for (i in 0 until it.posts.size) {
                    val item = it.posts[i]
                    data.add(
                        PostsData(
                            item.createdAt,
                            item.likes,
                            item.text,
                            item.userEmail,
                            item.userName,
                            item.userImg,
                            item.postId,
                            item.views
                        )
                    )
                }
                postsData.value = data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
