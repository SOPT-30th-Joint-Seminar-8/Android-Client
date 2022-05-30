package org.sopt.careerly_android.data.datasource.remote

import org.sopt.careerly_android.data.datasource.PostDataSource
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.service.PostService
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postService: PostService
) : PostDataSource {
    override suspend fun postPostWrite(data: RequestPostDTO) = postService.postPostWrite(data)
}
