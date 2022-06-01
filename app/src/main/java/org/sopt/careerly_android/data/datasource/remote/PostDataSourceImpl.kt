package org.sopt.careerly_android.data.datasource.remote

import org.sopt.careerly_android.data.datasource.PostDataSource
import org.sopt.careerly_android.data.remote.dto.BaseResponse
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.data.remote.dto.response.ResponseGetDTO
import org.sopt.careerly_android.data.remote.service.GetService
import org.sopt.careerly_android.data.remote.service.PostService
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postService: PostService,
    private val getService: GetService
) : PostDataSource {
    override suspend fun postPostWrite(data: RequestPostDTO) = postService.postPostWrite(data)

    override suspend fun getPostList() = getService.getPostList()
}
