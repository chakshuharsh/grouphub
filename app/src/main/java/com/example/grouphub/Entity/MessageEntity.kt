package com.example.grouphub.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="Messages",
    foreignKeys =
[
ForeignKey(
    entity = UserEntity::class,
    parentColumns = ["userId"],
    childColumns = ["senderId"],
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(
        entity = Group::class,
        parentColumns = ["userId"],
        childColumns = ["groupId"],
        onDelete = ForeignKey.CASCADE
    )


]
)
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val messageId:Long=0,
    val senderId: Long,// FK from userEntity
    val groupId: Long?,//FK from group
    val textMessage: String?,// Nullable as message can be only a media file as well
    val mediaURI: String?,// As message could be just text only
    val timeStamp: Long,
)