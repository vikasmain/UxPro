package com.example.uxpro

import com.example.uxpro.api.UxApiService
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
            .baseUrl("")
            .client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) =
        retrofit.create(UxApiService::class.java)

}