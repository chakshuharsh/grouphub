package com.example.grouphub.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Groups",
    foreignKeys = [
        ForeignKey(
            entity=UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["creatorId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Group(
    @PrimaryKey(autoGenerate = true)
    val groupId: Long = 0,
    val title: String,
    val description: String?,
    val dateCreated: Long,
    val creatorId: Long, // FK
    val numberOfMembers: Int,
    val numberOfAdmins: Int
)


