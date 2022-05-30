package org.sopt.careerly_android.ui.viewmodel

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

    fun postPostWrite() {
        viewModelScope.launch {
            postRepository.postPostWrite(
                RequestPostDTO(postMainText.value)
            ).onSuccess {

            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
