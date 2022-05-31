package org.sopt.careerly_android.ui.home

data class PostsData(
    val createdAt: String,
    val likes: Int,
    val text: String,
    val userEmail: String,
    val userName: String,
    val userImg: String,
    val postId: String,
    val views: Int
)