package com.example.grouphub.databaseDAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.grouphub.Entity.MessageEntity

@Dao
interface MessageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertMessage(message: MessageEntity)

    @Update
    suspend fun updateMessage(message:MessageEntity)


    @Delete
    suspend fun deleteMessage(message:MessageEntity)

    /**
     * Obtain a message from messageId
     */
    @Query("SELECT * FROM Messages WHERE messageId =:messageId")
    suspend fun getMessageById(messageId:Long):MessageEntity?

    /**
     * Obtains a list of all messages in the group. Newer messages come first.
     */
    @Query("SELECT * FROM Messages WHERE groupId =:groupId ORDER BY timeStamp DESC")
    suspend fun getAllMessagesOfGroup(groupId:Long):List<MessageEntity>

    /**
     * Deletes all message in a group by groupId
     */
    @Query("DELETE  FROM Messages WHERE groupId=:groupId ")
    suspend fun clearAllMessageFromGroup(groupId: Long)

    /**
     * Obtain all messages from a particular user/sender -> Pagination can be applied
     */
    @Query("SELECT * FROM Messages WHERE senderId = :senderId")
    suspend fun getMessagesBySender(senderId: Long): List<MessageEntity>


}