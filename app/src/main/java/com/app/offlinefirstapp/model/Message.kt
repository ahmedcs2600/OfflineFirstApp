package com.app.offlinefirstapp.model

data class Message(
    val id : String,
    val message : String,
    val createdAt : Long,
    val status : Int
)
