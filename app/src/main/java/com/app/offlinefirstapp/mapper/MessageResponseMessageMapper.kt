package com.app.offlinefirstapp.mapper

import com.app.offlinefirstapp.database.entities.MessageEntity
import com.app.offlinefirstapp.mapper.base.Mapper
import com.app.offlinefirstapp.model.Message
import com.app.offlinefirstapp.model.remote.MessageResponse
import javax.inject.Inject

class MessageResponseMessageMapper @Inject constructor() : Mapper<MessageResponse, Message> {
    override fun mapTo(item: MessageResponse): Message {
        return Message(
            id = item.id,
            message = item.message,
            createdAt = item.createdAt,
            status = MessageEntity.STATUS_PENDING
        )
    }
}