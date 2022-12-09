package com.app.offlinefirstapp.di

import com.app.offlinefirstapp.di.module.ViewModelModule
import com.app.offlinefirstapp.di.module.WorkManagerModule
import com.app.offlinefirstapp.ui.fragment.MessagingScreen
import dagger.Subcomponent

@Subcomponent(modules = [
    ViewModelModule::class,
    WorkManagerModule::class,
])
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : HomeComponent
    }

    fun inject(fragment : MessagingScreen)
}
