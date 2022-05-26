package org.sopt.careerly_android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.careerly_android.databinding.ItemReviewListBinding

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    val reviewList = mutableListOf<ReviewData>()

    class ReviewViewHolder(
        private val binding: ItemReviewListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ReviewData) {
            binding.tvName.text = data.name
            binding.tvPosition.text = "${data.position}ㆍ${data.time}"
            binding.tvReviewContent.text = data.content
            Glide.with(binding.imgProfile).load(data.image).circleCrop().into(binding.imgProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding =
            ItemReviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.onBind(reviewList[position])
    }

    override fun getItemCount(): Int = reviewList.size
}
