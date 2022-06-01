package org.sopt.careerly_android.data.remote.dto.response

import com.google.gson.annotations.SerializedName


data class ResponseGetDTO(
    @SerializedName("hotProfiles")
    val hotProfiles: List<HotProfile>,
    @SerializedName("posts")
    val posts: List<Post>
) {
    data class HotProfile(
        @SerializedName("followers")
        val followers: Int,
        @SerializedName("job")
        val job: String,
        @SerializedName("userName")
        val userName: String
    )

    data class Post(
        @SerializedName("createdAt")
        val createdAt: String,
        @SerializedName("likes")
        val likes: Int,
        @SerializedName("postId")
        val postId: String,
        @SerializedName("text")
        val text: String,
        @SerializedName("userEmail")
        val userEmail: String,
        @SerializedName("userImg")
        val userImg: String,
        @SerializedName("userName")
        val userName: String,
        @SerializedName("views")
        val views: Int
    )

}