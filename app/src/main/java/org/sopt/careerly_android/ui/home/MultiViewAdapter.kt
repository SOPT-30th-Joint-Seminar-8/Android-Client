package org.sopt.careerly_android.ui.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.careerly_android.databinding.ItemPostBinding
import org.sopt.careerly_android.databinding.RecyclerviewProfileBinding
import org.sopt.careerly_android.ui.post.detail.PostDetailActivity
import org.sopt.careerly_android.ui.viewmodel.HomeViewModel

class MultiViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val _data = mutableListOf<PostsData>()
    var data: List<PostsData> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    private val _profileData = mutableListOf<ProfileData>()
    var profileData: List<ProfileData> = _profileData
        set(value) {
            _profileData.clear()
            _profileData.addAll(value)
            notifyDataSetChanged()
        }


    private val profileInfo : MutableList<ProfileData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {

            CONTENT_TYPE -> {
                ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
                    ContentViewHolder(it)
                }
            }
            else -> {
                RecyclerviewProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ).let {
                    ProfileViewHolder(it)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        for(i in 0 until _profileData.size){
            profileInfo.add(ProfileData(_profileData[i].followers, _profileData[i].job, _profileData[i].userName))
        }
        when (position != 0 && position % 4 == 3) {
            false -> (holder as ContentViewHolder).bind(_data[position])
            else -> (holder as ProfileViewHolder).bind(profileInfo)
        }
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun getItemViewType(position: Int): Int =
        when (position != 0 && position % 4 == 3) {
            true -> PROFILE_TYPE
            else -> CONTENT_TYPE
        }

    class ContentViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostsData) {
            with(binding) {
                root.setOnClickListener {
                    root.context.startActivity(Intent(root.context, PostDetailActivity::class.java))
                }
                tvName.text = item.userName
                loadImage(sivImage, item.userImg)
                tvIntroduce.text = item.userEmail
                tvContent.text = item.text
                tvRecommend.text = item.likes.toString() + "명이 추천했어요"
                tvClick.text = "조회" + item.views.toString()
                tvTime.text = item.createdAt
            }
        }

        private fun loadImage(imageView: ImageView, image: String) {
            Glide.with(imageView)
                .load(image)
                .centerCrop()
                .into(imageView)
        }
    }

    class ProfileViewHolder(private val binding: RecyclerviewProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.rcvProfile.adapter = ProfileAdapter()
        }

        fun bind(item: MutableList<ProfileData>) {
            (binding.rcvProfile.adapter as ProfileAdapter).apply {
                data = item
            }
        }
    }
}