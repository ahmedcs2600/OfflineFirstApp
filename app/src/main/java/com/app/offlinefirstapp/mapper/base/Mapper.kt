package com.app.offlinefirstapp.mapper.base

interface Mapper<A, B> {
    fun mapTo(item : A) : B
}