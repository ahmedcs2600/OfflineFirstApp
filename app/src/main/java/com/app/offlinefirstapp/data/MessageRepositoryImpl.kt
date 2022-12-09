package com.app.offlinefirstapp.data

import com.app.offlinefirstapp.common.DataState
import com.app.offlinefirstapp.core.scheduler.AppSchedulers
import com.app.offlinefirstapp.local.LocalDataSource
import com.app.offlinefirstapp.mapper.MessageEntityMessageMapper
import com.app.offlinefirstapp.mapper.MessageResponseMessageMapper
import com.app.offlinefirstapp.model.Message
import com.app.offlinefirstapp.remote.RemoteDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteDataSource,
    private val localSource: LocalDataSource,
    private val mMessageResponseMessageMapper: MessageResponseMessageMapper,
    private val mMessageEntityMessageMapper: MessageEntityMessageMapper,
    private val appSchedulers: AppSchedulers
) : MessageRepository {

    override fun addMessage(message: String): Single<String> {
        return localSource.addMessage(message).subscribeOn(appSchedulers.io())
            .observeOn(appSchedulers.ui())
    }

    override fun getMessages(): Flowable<List<Message>> {
        return localSource.getMessages().map { list ->
            list.map { mMessageEntityMessageMapper.mapTo(it) }
        }.subscribeOn(appSchedulers.io()).observeOn(appSchedulers.ui())
    }

    override fun syncMessageToRemote(message: String): Single<DataState<Message>> {
        return remoteSource.send(message).map {
            when (it) {
                is DataState.Error -> DataState.Error(it.message)
                is DataState.Success -> DataState.Success(
                    mMessageResponseMessageMapper.mapTo(it.data)
                )
            }
        }.subscribeOn(appSchedulers.io()).observeOn(appSchedulers.ui())
    }

    override fun getMessageById(messageId: String): Single<Message> {
        return localSource.getMessageById(messageId).subscribeOn(appSchedulers.io())
            .observeOn(appSchedulers.ui()).map {
                mMessageEntityMessageMapper.mapTo(it)
            }
    }

    override fun updateMessageStatus(status: Int, messageId: String): Completable {
        return localSource.updateMessageStatus(status, messageId)
            .subscribeOn(appSchedulers.io())
            .observeOn(appSchedulers.ui())
    }
}