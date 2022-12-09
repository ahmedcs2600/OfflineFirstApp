package com.app.offlinefirstapp.di

import com.app.offlinefirstapp.services.sendmessage.WorkerCreator
import com.app.offlinefirstapp.services.sendmessage.SendMessageWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerBindingModule {

    @Binds
    @IntoMap
    @WorkerKey(SendMessageWorker::class)
    fun bindSendMessageWorker(factory : SendMessageWorker.Creator) : WorkerCreator

}