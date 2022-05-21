package org.sopt.careerly_android.ui.post.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.ActivityPostDetailBinding
import org.sopt.careerly_android.ui.ReviewAdapter
import org.sopt.careerly_android.ui.ReviewData
import org.sopt.careerly_android.util.binding.BindingActivity
import org.sopt.careerly_android.viewmodel.MainViewModel.Companion.EXAMPLE_PROFILE_IMAGE

class PostDetailActivity :
    BindingActivity<ActivityPostDetailBinding>(R.layout.activity_post_detail) {
    private lateinit var reviewAdapter: ReviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        binding.btnBack.setOnClickListener{
            finish()
        }

        Glide.with(this)
            .load(R.drawable.img_link)
            .circleCrop()
            .into(binding.imgProfile)

        Glide.with(this)
            .load(R.drawable.img_link)
            .circleCrop()
            .into(binding.imgSmallProfileLeft)

        Glide.with(this)
            .load(R.drawable.img_link)
            .circleCrop()
            .into(binding.imgSmallProfileRight)

    }

    private fun initAdapter() {
        reviewAdapter = ReviewAdapter()
        binding.rvReview.adapter = reviewAdapter
        reviewAdapter.reviewList.addAll(
            listOf(
                ReviewData(
                    "박세은",
                    "2시간 전",
                    "Product Designer.@hyp...",
                    "좋은 정보 감사합니다.",
                    EXAMPLE_PROFILE_IMAGE
                ), ReviewData(
                    "박세은",
                    "2시간 전",
                    "Product Designer.@hyp...",
                    "좋은 정보 감사합니다.",
                    EXAMPLE_PROFILE_IMAGE
                ), ReviewData(
                    "박세은",
                    "2시간 전",
                    "Product Designer.@hyp...",
                    "좋은 정보 감사합니다.",
                    EXAMPLE_PROFILE_IMAGE
                ),
                ReviewData(
                    "박세은",
                    "2시간 전",
                    "Product Designer.@hyp...",
                    "좋은 정보 감사합니다.",
                    EXAMPLE_PROFILE_IMAGE
                ),
                ReviewData(
                    "박세은",
                    "2시간 전",
                    "Product Designer.@hyp...",
                    "좋은 정보 감사합니다.",
                    EXAMPLE_PROFILE_IMAGE
                )
            )
        )
        reviewAdapter.notifyDataSetChanged()
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PostDetailActivity::class.java)
        }
    }
}
