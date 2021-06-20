package com.example.uxpro.deps

import android.app.Application
import com.example.uxpro.app.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
       ApiModule::class
    ]
)
interface MainActivityComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MainActivityComponent
    }

    fun inject(app: App)
}
