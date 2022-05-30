package org.sopt.careerly_android.data.remote.dto

data class BaseResponse<T>(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: T
)
