package org.sopt.careerly_android.data.datasource

import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseGetDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO

interface PostDataSource {
    suspend fun postPostWrite(data: RequestPostDTO): BaseResponse<ResponsePostDTO>

    suspend fun getPostList(): BaseResponse<ResponseGetDTO>
}
