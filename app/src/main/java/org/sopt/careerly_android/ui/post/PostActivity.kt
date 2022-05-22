package org.sopt.careerly_android.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.ActivityPostBinding
import org.sopt.careerly_android.ui.viewmodel.PostViewModel
import org.sopt.careerly_android.util.binding.BindingActivity

class PostActivity : BindingActivity<ActivityPostBinding>(R.layout.activity_post) {
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initTextChangeEvent()
    }

    private fun initTextChangeEvent() {
        with(binding) {
            etMainText.addTextChangedListener {
                tvComplete.isEnabled = !it.isNullOrEmpty()
            }
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PostActivity::class.java)
        }
    }
}