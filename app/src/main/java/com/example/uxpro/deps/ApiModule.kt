package com.example.uxpro.deps

import com.example.uxpro.api.UxApiService
import com.example.uxpro.repo.ApiRepository
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class ApiModule {

    @Provides
    @Singleton
    fun okhttpClient(): OkHttpClient.Builder {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://gymapi456.herokuapp.com/")
            .client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) =
        retrofit.create(UxApiService::class.java)

    @Provides
    @Singleton
    fun providesApiRepository(uxApiService: UxApiService): ApiRepository {
        return ApiRepository(uxApiService)
    }
}