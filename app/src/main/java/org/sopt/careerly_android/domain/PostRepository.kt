package org.sopt.careerly_android.domain

import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponsePostDTO

interface PostRepository {
    suspend fun postPostWrite(data: RequestPostDTO) : Result<ResponsePostDTO>
}
