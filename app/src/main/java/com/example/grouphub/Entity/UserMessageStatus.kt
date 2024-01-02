package com.example.grouphub.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName="MessageStatus",
    foreignKeys = [
    ForeignKey(
        entity=UserEntity::class,
        parentColumns = ["userId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    ),

    ForeignKey(
        entity=Group::class,
        parentColumns = ["groupId"],
        childColumns = ["groupId"],
        onDelete = ForeignKey.CASCADE
    ),

    ForeignKey(
        entity=MessageEntity::class,
        parentColumns = ["messageId"],
        childColumns = ["messageId"],
        onDelete = ForeignKey.CASCADE
    )
    ],
    indices = [
        Index(value=["userId"]),
        Index(value=["groupId"]),
        Index(value=["messageId"]),
    ] // We should consider it again as it slows down SELECT queries
    )
data class UserMessageStatus(
    val userId: Long,//Foreign key
    val groupId: Long,//Foreign key
    val messageId: Long,//Foreign key
    val isRead: Boolean = false,
    val isDelivered: Boolean = false

)