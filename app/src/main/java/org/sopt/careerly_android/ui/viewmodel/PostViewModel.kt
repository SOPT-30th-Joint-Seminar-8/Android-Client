package org.sopt.careerly_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.domain.PostRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    val postMainText = MutableLiveData<String>()

    private val _postDetailId = MutableLiveData<String>()
    val postDetailId: LiveData<String>
        get() = _postDetailId

    fun postPostWrite() {
        viewModelScope.launch {
            postRepository.postPostWrite(
                RequestPostDTO(postMainText.value)
            ).onSuccess {
                _postDetailId.value = it._id
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
