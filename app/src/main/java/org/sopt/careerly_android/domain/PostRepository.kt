package org.sopt.careerly_android.domain

import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseGetDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDetailDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseReplyDTO

interface PostRepository {
    suspend fun postPostWrite(data: RequestPostDTO) : Result<ResponsePostDTO>

    suspend fun getPostList(): Result<ResponseGetDTO>

    suspend fun postReply(data: RequestPostDTO, postId: String): Result<ResponseReplyDTO>

    suspend fun getPostDetail(postId: String): Result<List<ResponsePostDetailDTO>>
}
