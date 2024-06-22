package com.example.avtr.domain.usecase

import com.example.avtr.domain.repositori.AppRepositories

class GetUserPasswordUsecase(private val repositories: AppRepositories) {
    operator fun invoke()= repositories.getPassword()
}