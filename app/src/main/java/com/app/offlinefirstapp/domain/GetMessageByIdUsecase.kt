package com.app.offlinefirstapp.domain

import com.app.offlinefirstapp.data.MessageRepository
import com.app.offlinefirstapp.model.Message
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetMessageByIdUsecase @Inject constructor(
    private val mMessageRepository: MessageRepository
) {
    operator fun invoke(messageId : String): Single<Message> {
        return mMessageRepository.getMessageById(messageId)
    }
}