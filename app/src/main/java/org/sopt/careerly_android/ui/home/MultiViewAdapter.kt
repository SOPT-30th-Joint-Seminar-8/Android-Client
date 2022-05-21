package org.sopt.careerly_android.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.careerly_android.databinding.ItemPostBinding
import org.sopt.careerly_android.databinding.RecyclerviewProfileBinding

class MultiViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val _data = mutableListOf<MultiData>()
    var data: List<MultiData> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    private val profileInfo = mutableListOf(
        ProfileData("Hello"),
        ProfileData("Hello2"),
        ProfileData("Hello3")
    )

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

        fun bind(item: MultiData) {
            binding.tvName.text = item.name
            loadImage(binding.sivImage, item.profileImage)
            loadImage(binding.ivShareContent,item.postImage)
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