package com.app.offlinefirstapp.di.module

import com.app.offlinefirstapp.local.LocalDataSource
import com.app.offlinefirstapp.local.LocalDataSourceImpl
import com.app.offlinefirstapp.remote.RemoteDataSource
import com.app.offlinefirstapp.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDataSourceModule(dataSource: LocalDataSourceImpl) : LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(dataSource: RemoteDataSourceImpl) : RemoteDataSource
}
