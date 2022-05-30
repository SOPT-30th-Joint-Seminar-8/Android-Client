package org.sopt.careerly_android.data.remote.service

import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface PostService {
    // 게시글 작성
    @POST("post")
    suspend fun postPostWrite(@Body data: RequestPostDTO): BaseResponse<ResponsePostDTO>
}
