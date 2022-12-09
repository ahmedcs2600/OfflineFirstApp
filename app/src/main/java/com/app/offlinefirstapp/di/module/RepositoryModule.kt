package com.app.offlinefirstapp.di.module

import com.app.offlinefirstapp.data.MessageRepository
import com.app.offlinefirstapp.data.MessageRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMessageRepository(repository: MessageRepositoryImpl) : MessageRepository
}
