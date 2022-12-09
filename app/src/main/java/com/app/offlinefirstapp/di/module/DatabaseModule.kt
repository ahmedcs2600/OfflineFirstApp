package com.app.offlinefirstapp.di.module

import android.content.Context
import androidx.room.Room
import com.app.offlinefirstapp.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(applicationContext : Context) : AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun providesMessageDao(appDatabase: AppDatabase) = appDatabase.messageDao()
}
