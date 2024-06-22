package com.example.avtr.domain.usecase

import com.example.avtr.domain.entity.UserModel
import com.example.avtr.domain.repositori.AppRepositories

class AddUserUsecase(private val repositories: AppRepositories) {
    operator fun invoke(userModel: UserModel) = repositories.addUser(userModel)
}