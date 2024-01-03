package com.example.grouphub.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.Date

@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Long =0,
    val username: String,
    val profilePhoto: String?, // User might have photo or may be they can just show default photo
    val dateJoined: Long,
    val phoneNumber: String,
    val lastActiveTimestamp:Long// You might use it as it is assumed that no individual messaging is allowed
// but it can be used to display list of latest active users in a group
)
