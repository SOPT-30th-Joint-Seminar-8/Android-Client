package org.sopt.careerly_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDetailDTO
import org.sopt.careerly_android.domain.PostRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    val postMainText = MutableLiveData<String>()

    val postReply = MutableLiveData<String>()

    private val _postDetailReply = MutableLiveData<List<ResponsePostDetailDTO>>()
    val postDetailReply: LiveData<List<ResponsePostDetailDTO>>
        get() = _postDetailReply

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

    fun getPostDetail(postDetailId: String) {
        viewModelScope.launch {
            postRepository.getPostDetail(
                postDetailId
            ).onSuccess {
                _postDetailReply.value = it
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun postReply(postDetailId: String) {
        viewModelScope.launch {
            postRepository.postReply(
                RequestPostDTO(postReply.value),
                postDetailId
            ).onSuccess {

            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
