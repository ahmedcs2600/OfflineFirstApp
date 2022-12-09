package com.app.offlinefirstapp.domain

import com.app.offlinefirstapp.data.MessageRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AddNewMessageUsecase @Inject constructor(
    private val mMessagingRepository: MessageRepository
) {
    operator fun invoke(message: String): Single<String> {
        return mMessagingRepository.addMessage(message)
    }
}