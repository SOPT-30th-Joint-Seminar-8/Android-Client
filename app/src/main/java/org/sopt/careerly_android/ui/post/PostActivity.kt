package org.sopt.careerly_android.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.ActivityPostBinding
import org.sopt.careerly_android.ui.post.detail.PostDetailActivity
import org.sopt.careerly_android.ui.viewmodel.PostViewModel
import org.sopt.careerly_android.util.binding.BindingActivity

@AndroidEntryPoint
class PostActivity : BindingActivity<ActivityPostBinding>(R.layout.activity_post) {
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            vm = viewModel
            ibBack.setOnClickListener {
                finish()
            }
            tvComplete.setOnClickListener {
                viewModel.postPostWrite()
            }
        }
        initTextChangeEvent()
        observeData()
    }

    private fun observeData() {
        viewModel.postDetailId.observe(this) {
            startActivity(
                PostDetailActivity
                    .getIntent(this@PostActivity)
                    .putExtra(POST_ID, it)
            )
            finish()
        }
    }

    private fun initTextChangeEvent() {
        with(binding) {
            etMainText.addTextChangedListener {
                tvComplete.isEnabled = !it.isNullOrEmpty()
            }
        }
    }

    companion object {
        const val POST_ID = "POST_ID"

        fun getIntent(context: Context): Intent {
            return Intent(context, PostActivity::class.java)
        }
    }
}