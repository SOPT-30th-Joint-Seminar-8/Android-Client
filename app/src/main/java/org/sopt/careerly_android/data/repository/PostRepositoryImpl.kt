package org.sopt.careerly_android.data.repository

import org.sopt.careerly_android.data.datasource.PostDataSource
import org.sopt.careerly_android.data.remote.dto.request.RequestPostDTO
import org.sopt.careerly_android.domain.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val dataSource: PostDataSource
) : PostRepository {
    override suspend fun postPostWrite(data: RequestPostDTO) = runCatching {
        dataSource.postPostWrite(data).data
    }

    override suspend fun getPostList() = runCatching {
        dataSource.getPostList().data
    }

    override suspend fun postReply(data: RequestPostDTO, postId: String) = runCatching {
        dataSource.postReply(data, postId)
    }

    override suspend fun getPostDetail(postId: String) = runCatching {
        dataSource.getPostDetail(postId).data
    }
}
