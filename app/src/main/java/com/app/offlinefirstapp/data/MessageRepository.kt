package com.app.offlinefirstapp.data

import com.app.offlinefirstapp.common.DataState
import com.app.offlinefirstapp.model.Message
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface MessageRepository {

    fun addMessage(message: String) : Single<String>

    fun getMessages() : Flowable<List<Message>>

    fun syncMessageToRemote(message : String) : Single<DataState<Message>>

    fun getMessageById(messageId : String) : Single<Message>

    fun updateMessageStatus(status : Int, messageId: String) : Completable
}