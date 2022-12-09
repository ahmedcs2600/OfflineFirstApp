package com.app.offlinefirstapp.remote

import com.app.offlinefirstapp.common.DataState
import com.app.offlinefirstapp.model.remote.MessageResponse
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun send(message : String) : Single<DataState<MessageResponse>>
}