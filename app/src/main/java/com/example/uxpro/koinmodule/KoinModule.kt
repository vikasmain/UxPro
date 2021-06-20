package com.example.uxpro.koinmodule

import com.example.uxpro.api.UxApiService
import com.example.uxpro.repo.ApiRepository
import com.example.uxpro.viewmodel.MainActivityViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}

val repositoryModule = module {
    single {
        ApiRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): UxApiService {
        return retrofit.create(UxApiService::class.java)
    }

    single { provideUseApi(get()) }
}

val retrofitModule = module {

    fun providesGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun providesHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun providesRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gymapi456.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { providesGson() }
    single { providesHttpClient() }
    single { providesRetrofit(get(), get()) }
}
