package com.example.avtr.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 1,
    var serverId: Int = -1,
    var password: Int
)