package com.example.grouphub.databaseDAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.grouphub.Entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//Insert function for adding new user
    suspend fun addUser(user: UserEntity)

    @Query("DELETE FROM Users WHERE user_id = :userId")// Deleting users
    suspend fun deleteUser(userId: Int)

    @Query("SELECT*FROM Users WHERE user_id = :userId")
    suspend fun getUserById(userId: Int): UserEntity?

    @Query("SELECT * FROM Users")
    suspend fun getAllUsers(): List<UserEntity>//

    @Update
    suspend fun updateUser(user: UserEntity)// Updating the User

}