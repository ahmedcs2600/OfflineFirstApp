package com.app.offlinefirstapp.di

import android.content.Context
import androidx.work.WorkerFactory
import com.app.offlinefirstapp.App
import com.app.offlinefirstapp.di.module.*
import com.app.offlinefirstapp.services.sendmessage.CustomWorkerFactory
import com.app.offlinefirstapp.ui.fragment.MessagingScreen
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DatabaseModule::class,
    AppSubcomponents::class,
    WorkerBindingModule::class,
    AppSchedulersModule::class,
    RepositoryModule::class,
    DataSourceModule::class,
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context : Context) : AppComponent
    }

    fun inject(app : App)

    fun homeComponent() : HomeComponent.Factory
}
