package com.app.offlinefirstapp.domain

import com.app.offlinefirstapp.data.MessageRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class UpdateMessageStatusUsecase @Inject constructor(private val mMessageRepository: MessageRepository) {
    operator fun invoke(status : Int, messageId : String) : Completable {
        return mMessageRepository.updateMessageStatus(status, messageId)
    }
}