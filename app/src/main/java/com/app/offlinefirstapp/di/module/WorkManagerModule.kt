package com.app.offlinefirstapp.di.module

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WorkManagerModule {

    @Provides
    fun providesWorkManager(appContext: Context) = WorkManager.getInstance(appContext)

    @Provides
    fun providesConstrainModule(): Constraints {
        return Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
    }
}
