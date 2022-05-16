package org.sopt.careerly_android.util

import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

fun AppCompatActivity.px(dp: Int) = (dp * resources.displayMetrics.density).roundToInt()
