package com.app.offlinefirstapp.services.sendmessage

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.rxjava3.RxWorker
import com.app.offlinefirstapp.common.DataState
import com.app.offlinefirstapp.database.entities.MessageEntity
import com.app.offlinefirstapp.domain.GetMessageByIdUsecase
import com.app.offlinefirstapp.domain.SyncMessageToRemoteUsecase
import com.app.offlinefirstapp.domain.UpdateMessageStatusUsecase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SendMessageWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val mGetMessageById : GetMessageByIdUsecase,
    private val mSyncMessageToRemote : SyncMessageToRemoteUsecase,
    private val mUpdateMessageStatus : UpdateMessageStatusUsecase,
) : RxWorker(
    appContext, workerParams
) {
    override fun createWork(): Single<Result> {
        val messageId : String = checkNotNull(inputData.getString(SendMessageWorkerBuilder.MESSAGE_ID))
        return mGetMessageById.invoke(messageId).flatMap {
              mSyncMessageToRemote.invoke(it.message).flatMap { state ->
                when(state) {
                    is DataState.Error -> {
                        Single.just(Result.retry())
                    }
                    is DataState.Success -> {
                        mUpdateMessageStatus.invoke(
                            MessageEntity.STATUS_SENT,
                            messageId).andThen(Single.just(Result.success()))
                    }
                }
            }
        }
    }

    class Creator @Inject constructor(
        private val mGetMessageById : GetMessageByIdUsecase,
        private val mSyncMessageToRemote : SyncMessageToRemoteUsecase,
        private val mUpdateMessageStatus : UpdateMessageStatusUsecase,
    ) : WorkerCreator {
        override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
            return SendMessageWorker(
                appContext,
                params,
                mGetMessageById,
                mSyncMessageToRemote,
                mUpdateMessageStatus,
            )
        }
    }
}