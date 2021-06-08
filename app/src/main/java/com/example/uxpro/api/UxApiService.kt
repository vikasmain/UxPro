package com.example.uxpro.api

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface UxApiService {
    @GET("uxitems")
    suspend fun getUxItems(): Response<UxItemsResponse>
}