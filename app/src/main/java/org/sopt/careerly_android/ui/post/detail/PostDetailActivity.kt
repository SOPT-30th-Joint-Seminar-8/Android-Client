package org.sopt.careerly_android.ui.post.detail

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.ActivityPostDetailBinding
import org.sopt.careerly_android.ui.ReviewAdapter
import org.sopt.careerly_android.ui.ReviewData
import org.sopt.careerly_android.ui.post.PostActivity.Companion.POST_ID
import org.sopt.careerly_android.ui.viewmodel.MainViewModel.Companion.EXAMPLE_PROFILE_IMAGE
import org.sopt.careerly_android.ui.viewmodel.PostViewModel
import org.sopt.careerly_android.util.binding.BindingActivity

class PostDetailActivity :
    BindingActivity<ActivityPostDetailBinding>(R.layout.activity_post_detail) {
    private val viewModel: PostViewModel by viewModels()

    private lateinit var reviewAdapter: ReviewAdapter
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()

        viewModel.getPostDetail(intent.getStringExtra(POST_ID) ?: "")

        binding.btnBack.setOnClickListener {
            finish()
        }
        textView = findViewById(R.id.tv_recommend_number)

        val textData: String = textView.text.toString()

        val builder = SpannableStringBuilder(textData)

        val boldSpan = StyleSpan(Typeface.BOLD)
        builder.setSpan(boldSpan, 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

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

        initClickEvent()
        observeData()
    }

    private fun initAdapter() {
        // TODO : 이부분을 아래 어댑터 + 데이터 연동로직으로 빼주시면 간단할거에요!
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

    private fun observeData() {
        viewModel.postDetailReply.observe(this) {
            // TODO : 댓글리스트 + 어댑터 연동 여기서
        }
    }

    private fun initClickEvent() {
        binding.btnRegistration.setOnClickListener {
            viewModel.postReply(
                intent.getStringExtra(POST_ID) ?: ""
            )
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PostDetailActivity::class.java)
        }
    }
}
