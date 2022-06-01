package org.sopt.careerly_android.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.FragmentHomeBinding
import org.sopt.careerly_android.ui.post.PostActivity
import org.sopt.careerly_android.ui.viewmodel.HomeViewModel
import org.sopt.careerly_android.util.binding.BindingFragment

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var multiAdapter: MultiViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        observeData()
        observeProfileData()
        viewModel.getPostList()
        viewModel.getProfileData()
        initRecycler()
    }

    fun btnGoToPost(){
        startActivity(Intent(activity,PostActivity::class.java))
    }

    private fun observeData() {
        viewModel.postsData.observe(viewLifecycleOwner) {
            multiAdapter.data = it
        }
    }

    private fun observeProfileData() {
        viewModel.profileData.observe(viewLifecycleOwner) {
            multiAdapter.profileData = it
            Log.d("LEEE", it.toString())
        }
    }

    private fun initRecycler() {
        multiAdapter = MultiViewAdapter()
        binding.rvHome.adapter = multiAdapter
    }
}
