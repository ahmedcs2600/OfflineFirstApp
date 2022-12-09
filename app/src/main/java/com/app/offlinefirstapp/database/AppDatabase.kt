package com.app.offlinefirstapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.offlinefirstapp.database.dao.MessageDao
import com.app.offlinefirstapp.database.entities.MessageEntity

@Database(entities = [MessageEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "app_database"
    }

    abstract fun messageDao() : MessageDao
}
