package org.sopt.careerly_android.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.careerly_android.R

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PostActivity::class.java)
        }
    }
}