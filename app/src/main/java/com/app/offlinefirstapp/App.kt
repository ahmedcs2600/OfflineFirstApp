package com.app.offlinefirstapp

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.app.offlinefirstapp.di.AppComponent
import com.app.offlinefirstapp.di.DaggerAppComponent
import com.app.offlinefirstapp.services.sendmessage.CustomWorkerFactory
import javax.inject.Inject

class App : Application(), Configuration.Provider {

    val appComponent : AppComponent by lazy {
        initializeComponent()
    }

    @Inject
    lateinit var mCustomWorkerFactory : CustomWorkerFactory

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration
            .Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .setWorkerFactory(mCustomWorkerFactory)
            .build()
    }
}