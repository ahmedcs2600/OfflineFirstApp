package com.app.offlinefirstapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageEntity(
    @PrimaryKey val id : String,
    val message : String,
    val createdAt : Long,
    val status : Int = STATUS_PENDING
) {
    companion object {
        const val STATUS_PENDING = 1
        const val STATUS_SENT = 2
    }
}
