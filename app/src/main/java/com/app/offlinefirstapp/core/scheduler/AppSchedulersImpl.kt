package com.app.offlinefirstapp.core.scheduler

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AppSchedulersImpl @Inject constructor(): AppSchedulers {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
       return AndroidSchedulers.mainThread()
    }
}