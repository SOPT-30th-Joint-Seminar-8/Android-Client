package org.sopt.careerly_android.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.careerly_android.R
import org.sopt.careerly_android.databinding.FragmentHomeBinding
import org.sopt.careerly_android.ui.viewmodel.HomeViewModel
import org.sopt.careerly_android.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var multiAdapter: MultiViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMultiData()
        initRecycler()
        observeData()
    }

    private fun observeData() {
        viewModel.multiData.observe(viewLifecycleOwner) {
            multiAdapter.data = it
        }
    }

    private fun initRecycler() {
        multiAdapter = MultiViewAdapter()
        binding.rvHome.adapter = multiAdapter
    }
}
