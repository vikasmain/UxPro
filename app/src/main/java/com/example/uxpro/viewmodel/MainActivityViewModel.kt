package com.example.uxpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.uxpro.api.UxResponse
import com.example.uxpro.repo.ApiRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    val data: LiveData<Resource<UxResponse>>
        get() = getUsers()

    private fun getUsers() = liveData(Dispatchers.IO) {
        try {
            emit(Resource.success(data = apiRepository.getUxItemsList()))
        } catch (throwable: Throwable) {
            emit(Resource.error(null, message = "Error Message"))
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}

data class Resource<out T>(val status: Status, val data: T?, val errorMessage: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, errorMessage = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = Status.ERROR, data = data, errorMessage = message)
    }
}

enum class Status {
    SUCCESS,
    ERROR
}
