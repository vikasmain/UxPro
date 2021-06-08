package com.example.uxpro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uxpro.repo.ApiRepository
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(
    private val apiRepository: ApiRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(apiRepository) as T
        }
        throw IllegalArgumentException ("View Model not found")
    }
}