package org.sopt.careerly_android.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.ActivityPostBinding
import org.sopt.careerly_android.util.binding.BindingActivity

class PostActivity : BindingActivity<ActivityPostBinding>(R.layout.activity_post) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PostActivity::class.java)
        }
    }
}