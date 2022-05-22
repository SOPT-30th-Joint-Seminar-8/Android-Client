package org.sopt.careerly_android.ui.post.detail

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
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
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        binding.btnBack.setOnClickListener{
            finish()
        }
        textView = findViewById(R.id.tv_recommend_number)

        val textData: String = textView.text.toString()

        val builder = SpannableStringBuilder(textData)

        val boldSpan = StyleSpan(Typeface.BOLD)
        builder.setSpan(boldSpan,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = builder

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
