package com.app.offlinefirstapp.local

import com.app.offlinefirstapp.database.entities.MessageEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface LocalDataSource {

    fun getMessages() : Flowable<List<MessageEntity>>

    fun addMessage(message: String) : Single<String>

    fun getMessageById(messageId : String) : Single<MessageEntity>

    fun updateMessageStatus(status : Int, messageId: String) : Completable
}
