package com.example.uxpro.repo

import com.example.uxpro.api.UxApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: UxApiService
) {
    suspend fun getUxItemsList() = apiService.getUxItems()

}
