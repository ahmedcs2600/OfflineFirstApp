package com.app.offlinefirstapp.mapper

import com.app.offlinefirstapp.database.entities.MessageEntity
import com.app.offlinefirstapp.mapper.base.Mapper
import com.app.offlinefirstapp.model.Message
import javax.inject.Inject

class MessageEntityMessageMapper @Inject constructor() : Mapper<MessageEntity, Message> {
    override fun mapTo(item: MessageEntity): Message {
        return  Message(
            id = item.id,
            message = item.message,
            createdAt = item.createdAt,
            status = item.status
        )
    }
}