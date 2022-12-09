package com.app.offlinefirstapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.offlinefirstapp.core.ViewModelFactory
import com.app.offlinefirstapp.di.ViewModelKey
import com.app.offlinefirstapp.ui.viewmodel.MessagingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MessagingViewModel::class)
    abstract fun messagingViewModel(viewModel: MessagingViewModel): ViewModel
}
