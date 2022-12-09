package com.app.offlinefirstapp.domain

import com.app.offlinefirstapp.common.DataState
import com.app.offlinefirstapp.data.MessageRepository
import com.app.offlinefirstapp.model.Message
import io.reactivex.rxjava3.core.Single

import javax.inject.Inject

class SyncMessageToRemoteUsecase @Inject constructor(
    private val mMessagingRepository: MessageRepository
) {
    operator fun invoke(message : String): Single<DataState<Message>> {
        return mMessagingRepository.syncMessageToRemote(message)
    }
}