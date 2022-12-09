package com.app.offlinefirstapp.remote

import com.app.offlinefirstapp.common.DataState
import com.app.offlinefirstapp.model.remote.MessageResponse
import io.reactivex.rxjava3.core.Single
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {
    override fun send(message: String): Single<DataState<MessageResponse>> {
        return Single.just<DataState<MessageResponse>>(
            DataState.Success(
                data = MessageResponse(
                    id = UUID.randomUUID().toString(),
                    message = message,
                    createdAt = System.currentTimeMillis()
                )
            )
        ).delay(5, TimeUnit.SECONDS)
    }
}