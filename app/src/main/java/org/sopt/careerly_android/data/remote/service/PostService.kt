package org.sopt.careerly_android.data.remote.service

import android.telecom.Call
import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface PostService {
    // 게시글 작성
    @POST("post")
    suspend fun postPostWrite(@Body data: RequestPostDTO): BaseResponse<ResponsePostDTO>
    // 특정 게시글 댓글 작성
    @POST("/review/post/:postID")
    fun postReviewWrite(
        @Body data: RequestPostDTO) : BaseResponse<ResponsePostDTO>
}
