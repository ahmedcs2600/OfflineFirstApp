package com.app.offlinefirstapp.local

import com.app.offlinefirstapp.database.dao.MessageDao
import com.app.offlinefirstapp.database.entities.MessageEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import java.util.*
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val messageDao: MessageDao,
) : LocalDataSource {

    override fun getMessages(): Flowable<List<MessageEntity>> {
        return messageDao.getMessages()
    }

    override fun addMessage(message: String): Single<String> {
        val id = UUID.randomUUID().toString()

        val newMessage = MessageEntity(
            id = id,
            message = message,
            createdAt = System.currentTimeMillis(),
            status = MessageEntity.STATUS_PENDING
        )

        return messageDao.insert(newMessage).andThen(Single.just(id))
    }

    override fun getMessageById(messageId: String): Single<MessageEntity> {
        return messageDao.getMessageById(messageId)
    }

    override fun updateMessageStatus(status: Int, messageId: String): Completable {
        return messageDao.updateMessageStatus(status, messageId)
    }
}