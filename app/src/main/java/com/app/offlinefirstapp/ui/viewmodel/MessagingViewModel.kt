package com.app.offlinefirstapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.app.offlinefirstapp.core.MviViewModel
import com.app.offlinefirstapp.domain.AddNewMessageUsecase
import com.app.offlinefirstapp.domain.GetMessagesUsecase
import com.app.offlinefirstapp.model.Message
import com.app.offlinefirstapp.services.sendmessage.SendMessageWorkerBuilder
import javax.inject.Inject
import javax.inject.Provider

class MessagingViewModel @Inject constructor(
    private val mGetMessagesUsecase: Provider<GetMessagesUsecase>,
    private val mAddNewMessageUsecase: Provider<AddNewMessageUsecase>,
    private val mSendMessageWorkerBuilder: Provider<SendMessageWorkerBuilder>
) : MviViewModel() {

    val message: LiveData<List<Message>>
        get() = LiveDataReactiveStreams.fromPublisher(mGetMessagesUsecase.get().invoke())

    fun sendMessage(message: String) {
        mAddNewMessageUsecase.get().invoke(message).subscribe({ messageId ->
            mSendMessageWorkerBuilder.get().create(messageId)
        }, {
            Log.e("Error", it.message ?: "")
        })
    }
}