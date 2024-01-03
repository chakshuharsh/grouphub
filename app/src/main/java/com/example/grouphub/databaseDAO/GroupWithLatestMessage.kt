package com.example.grouphub.databaseDAO

import androidx.room.DatabaseView

@DatabaseView(
    "SELECT "
)

data class GroupWithLatestMessage {
    val id : Long,
            val text : String ="",
                    val timestamp : Long =-1,
}