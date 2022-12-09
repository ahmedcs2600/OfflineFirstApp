package com.app.offlinefirstapp.di.module

import com.app.offlinefirstapp.core.scheduler.AppSchedulers
import com.app.offlinefirstapp.core.scheduler.AppSchedulersImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppSchedulersModule {

    @Binds
    abstract fun bindsAppSchedulers(schedulers: AppSchedulersImpl) : AppSchedulers

}
