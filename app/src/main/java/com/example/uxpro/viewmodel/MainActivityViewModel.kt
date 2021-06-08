package com.example.uxpro.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.uxpro.api.UxItemsResponse
import com.example.uxpro.repo.ApiRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val liveData = MutableLiveData<UxItemsResponse>()
    private var uxItemsJob: Job? = null
    fun getUsers() {
        uxItemsJob?.cancel()
        uxItemsJob = viewModelScope.launch {
            val response = apiRepository.getUxItemsList()
            if (response.isSuccessful) {
                liveData.value = response.body()
            } else {
                liveData.value = null
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        uxItemsJob?.cancel()
    }
}
