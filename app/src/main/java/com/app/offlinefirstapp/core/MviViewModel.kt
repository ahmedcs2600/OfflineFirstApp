package com.app.offlinefirstapp.core

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class MviViewModel : ViewModel() {
    private val disposable = CompositeDisposable()

    fun Disposable.addToDisposable() {
        disposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}