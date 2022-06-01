package org.sopt.careerly_android.data.remote.dto.response

import java.util.*


data class ResponseGetDTO(
    val hotProfiles: List<HotProfile>,
    val posts: List<Post>,
    val reviews: List<Reviews>
) {
    data class HotProfile(
        val followers: Int,
        val job: String,
        val userName: String
    )

    data class Post(
        val createdAt: String,
        val likes: Int,
        val postId: String,
        val text: String,
        val userEmail: String,
        val userImg: String,
        val userName: String,
        val views: Int
    )

    data class Reviews(
        val reviewID : String,
        val userName: String,
        val userEmail: String,
        val userImg: String,
        val text: String,
        val createdAt: Date,
    )

}