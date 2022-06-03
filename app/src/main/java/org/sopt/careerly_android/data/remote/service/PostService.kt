package org.sopt.careerly_android.data.remote.service

import android.telecom.Call
import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDetailDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseReplyDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {
    // 게시글 작성
    @POST("post")
    suspend fun postPostWrite(@Body data: RequestPostDTO): BaseResponse<ResponsePostDTO>

    // 게시글 댓글 작성
    @POST("review/post/{postId}")
    suspend fun postReply(
        @Body data: RequestPostDTO,
        @Path("postId") postId: String
    ): ResponseReplyDTO

    // 게시글 상세
    @GET("review/post/{postId}")
    suspend fun getPostDetail(
        @Path("postId") postId: String
    ): BaseResponse<List<ResponsePostDetailDTO>>
}
