package com.app.offlinefirstapp.services.sendmessage


import androidx.work.*
import javax.inject.Inject

class SendMessageWorkerBuilder @Inject constructor(
    private val manager: WorkManager,
    private val constraints: Constraints,
) {
    companion object {
        const val MESSAGE_ID = "MESSAGE_ID"
    }

    fun create(messageId: String) {
        val builder = OneTimeWorkRequestBuilder<SendMessageWorker>()
        val data = workDataOf(
            MESSAGE_ID to messageId
        )
        builder.setInputData(data)
        builder.setConstraints(constraints)
        builder.setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
        manager.enqueue(builder.build())
    }
}