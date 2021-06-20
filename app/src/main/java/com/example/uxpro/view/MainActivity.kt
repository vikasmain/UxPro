package com.example.uxpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.uxpro.databinding.ActivityMainBinding
import com.example.uxpro.view.adapter.UxItemsAdapter
import com.example.uxpro.viewmodel.MainActivityViewModel
import com.example.uxpro.viewmodel.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding
    private val uxItemsAdapter = UxItemsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        observeViewModel()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }

    private fun observeViewModel() {
        mainActivityViewModel.data.observe(this, {
            when (it?.status) {
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    it.data?.value?.let {
                        uxItemsAdapter.updateUxItemsList(it)
                    }
                }
            }
        })
    }
}
