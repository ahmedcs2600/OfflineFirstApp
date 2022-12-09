package com.app.offlinefirstapp.common

sealed class DataState<T>{
    data class Success<T>(val data : T) : DataState<T>()
    data class Error<T>(val message : String) : DataState<T>()
}