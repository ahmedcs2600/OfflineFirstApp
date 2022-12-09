package com.app.offlinefirstapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.offlinefirstapp.database.entities.MessageEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

@Dao
interface MessageDao {

    @Insert
    fun insert(message : MessageEntity) : Completable

    @Query("SELECT * FROM MessageEntity ORDER BY createdAt ASC")
    fun getMessages() : Flowable<List<MessageEntity>>

    @Query("SELECT * FROM MessageEntity WHERE id=:messageId")
    fun getMessageById(messageId : String) : Single<MessageEntity>

    @Query("UPDATE MessageEntity SET status=:status WHERE id=:messageId")
    fun updateMessageStatus(status : Int, messageId: String) : Completable
}
