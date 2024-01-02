package com.example.grouphub.databaseDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.grouphub.Entity.MessageEntity

@Dao
interface MessageDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMessage(message:MessageEntity)

    @Update
    suspend fun updateMessage(message:MessageEntity)

    @Query("SELECT * FROM Messages WHERE messageId = :messageId")
    suspend fun getMessage(messageId: Int): MessageEntity?

    @Query("DELETE FROM Messages WHERE messageId = :messageId")
    suspend fun deleteMessage(messageId: Int)

    @Query("SELECT * FROM Messages")
    suspend fun getAllMessages(): List<MessageEntity>
}