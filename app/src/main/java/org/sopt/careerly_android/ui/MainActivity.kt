package org.sopt.careerly_android.ui

import android.graphics.Bitmap
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.MenuItemCompat
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.ActivityMainBinding
import org.sopt.careerly_android.ui.home.HomeFragment
import org.sopt.careerly_android.ui.viewmodel.MainViewModel
import org.sopt.careerly_android.util.binding.BindingActivity
import org.sopt.careerly_android.util.borderedCircularBitmap
import org.sopt.careerly_android.util.ext.replace
import org.sopt.careerly_android.util.px

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(R.id.item_home)
        viewModel.getProfileBitmap()
        initBottomNavigation()
        observeData()
    }

    private fun observeData() {
        viewModel.profileBitmap.observe(this) {
            setProfile(it, R.color.ltgray1)
        }
    }

    private fun setProfile(bitmap: Bitmap?, colorId: Int) {
        binding.bnvMain.menu.findItem(R.id.item_profile).icon = BitmapDrawable(
            resources,
            bitmap?.borderedCircularBitmap(getColor(colorId), px(10))
        )
    }

    private fun initBottomNavigation() {
        MenuItemCompat.setIconTintMode(
            binding.bnvMain.menu.findItem(R.id.item_profile),
            PorterDuff.Mode.DST
        )

        binding.bnvMain.setOnItemSelectedListener {
            replaceFragment(it.itemId)
            setProfile(
                viewModel.profileBitmap.value, when (it.itemId) {
                    R.id.item_profile -> {
                        R.color.careerly_red
                    }
                    else -> {
                        R.color.ltgray1
                    }
                }
            )
            true
        }
    }

    private fun replaceFragment(itemId: Int) {
        when (itemId) {
            R.id.item_home -> replace<HomeFragment>(R.id.container_main)
            else -> replace<EmptyFragment>(R.id.container_main)
        }
    }
}
