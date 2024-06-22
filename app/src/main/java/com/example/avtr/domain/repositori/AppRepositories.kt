package com.example.avtr.domain.repositori

import com.example.avtr.domain.entity.UserModel

interface AppRepositories {
    fun addUser(userModel: UserModel)
    fun getPassword(): Int
    fun getServerId(): Int
    fun isRegistr(): Boolean
}