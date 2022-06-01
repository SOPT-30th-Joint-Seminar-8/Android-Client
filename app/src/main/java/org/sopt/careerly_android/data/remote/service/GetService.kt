package org.sopt.careerly_android.data.remote.service

import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.response.ResponseGetDTO
import retrofit2.http.GET

interface GetService {
    // 게시글 불러오기
    @GET("post")
    suspend fun getPostList(): BaseResponse<ResponseGetDTO>
}