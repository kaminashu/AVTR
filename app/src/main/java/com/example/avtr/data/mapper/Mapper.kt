package com.example.avtr.data.mapper

import com.example.avtr.data.database.UserDbModel
import com.example.avtr.domain.entity.UserModel

class Mapper {
    fun mapUserModelToUserModelDb(userModel: UserModel): UserDbModel {
        return UserDbModel(password = userModel.password)
    }
}