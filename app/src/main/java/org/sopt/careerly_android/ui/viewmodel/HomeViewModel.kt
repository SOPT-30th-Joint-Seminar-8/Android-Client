package org.sopt.careerly_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.careerly_android.ui.home.MultiData
import org.sopt.careerly_android.ui.viewmodel.MainViewModel.Companion.EXAMPLE_PROFILE_IMAGE
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _multiData = MutableLiveData<List<MultiData>>()
    val multiData: LiveData<List<MultiData>>
        get() = _multiData

    fun getMultiData() {
        val data = mutableListOf<MultiData>()
        for (i in 1..7) {
            data.add(MultiData("Hello${i}", EXAMPLE_PROFILE_IMAGE, EXAMPLE_PROFILE_IMAGE))
        }
        _multiData.value = data
    }
}
