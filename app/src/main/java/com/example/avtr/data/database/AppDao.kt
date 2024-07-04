package com.example.avtr.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBase(userDbModel: UserDbModel)

    @Query("SELECT password FROM users where userId=1")
    fun getUserLocalPassword(): Int

    @Query("SELECT serverId FROM users where userId=1")
    fun getUserServerId(): Int

    @Query("SELECT count(*) FROM users")
    fun getCount(): Int
}