package com.example.uxpro.repo

import com.example.uxpro.api.UxApiService
import com.example.uxpro.api.UxItemsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: UxApiService
) {
    suspend fun getUxItemsList(): Response<UxItemsResponse> {
        return apiService.getUxItems()
    }
}