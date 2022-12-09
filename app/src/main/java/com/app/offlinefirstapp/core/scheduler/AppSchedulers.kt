package com.app.offlinefirstapp.core.scheduler

import io.reactivex.rxjava3.core.Scheduler


interface AppSchedulers {
    fun io(): Scheduler

    fun ui(): Scheduler
}