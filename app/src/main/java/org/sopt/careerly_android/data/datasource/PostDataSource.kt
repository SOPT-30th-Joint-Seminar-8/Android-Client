package org.sopt.careerly_android.data.datasource

import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseGetDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDetailDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseReplyDTO

interface PostDataSource {
    suspend fun postPostWrite(data: RequestPostDTO): BaseResponse<ResponsePostDTO>

    suspend fun getPostList(): BaseResponse<ResponseGetDTO>

    suspend fun postReply(data: RequestPostDTO, postId: String): ResponseReplyDTO

    suspend fun getPostDetail(postId: String): BaseResponse<List<ResponsePostDetailDTO>>
}
