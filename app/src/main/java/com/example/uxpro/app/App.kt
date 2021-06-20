package com.example.uxpro.app

import android.app.Application
import com.example.uxpro.deps.MainActivityComponent
import com.example.uxpro.deps.ApiModule
import com.example.uxpro.koinmodule.apiModule
import com.example.uxpro.koinmodule.repositoryModule
import com.example.uxpro.koinmodule.retrofitModule
import com.example.uxpro.koinmodule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}
