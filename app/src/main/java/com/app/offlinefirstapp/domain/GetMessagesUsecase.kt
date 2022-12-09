package com.app.offlinefirstapp.domain

import com.app.offlinefirstapp.data.MessageRepository
import com.app.offlinefirstapp.model.Message
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class GetMessagesUsecase @Inject constructor(
    private val mMessagingRepository: MessageRepository
) {
    operator fun invoke() : Flowable<List<Message>> {
        return mMessagingRepository.getMessages()
    }
}