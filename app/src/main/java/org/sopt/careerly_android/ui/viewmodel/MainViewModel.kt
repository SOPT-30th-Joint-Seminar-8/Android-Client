package org.sopt.careerly_android.ui.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.sopt.careerly_android.util.ImageDownloadManager.getImage
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _profileBitmap = MutableLiveData<Bitmap?>()
    val profileBitmap: LiveData<Bitmap?>
        get() = _profileBitmap

    @DelicateCoroutinesApi
    @ExperimentalCoroutinesApi
    fun getProfileBitmap() {
        viewModelScope.launch {
            _profileBitmap.value = getImage(EXAMPLE_PROFILE_IMAGE)
        }
    }

    companion object {
        const val EXAMPLE_PROFILE_IMAGE =
            "http://imagescdn.gettyimagesbank.com/500/201905/jv11366256.jpg"
    }
}
