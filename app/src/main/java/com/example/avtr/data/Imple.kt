package com.example.avtr.data

import android.content.Context
import com.example.avtr.data.database.AppDatabase
import com.example.avtr.data.mapper.Mapper
import com.example.avtr.domain.entity.UserModel
import com.example.avtr.domain.repositori.AppRepositories

class Imple(context: Context) : AppRepositories {
    val db = AppDatabase.getInstance(context).appService()
    val mapper = Mapper()
    override fun addUser(userModel: UserModel) {
        db.addBase(mapper.mapUserModelToUserModelDb(userModel))
    }

    override fun getPassword(): Int {
        return db.getUserLocalPassword()
    }

    override fun getServerId(): Int {
        return db.getUserServerId()
    }

    override fun isRegistr(): Boolean {
        val count = db.getCount()
        return count > 0
    }
}