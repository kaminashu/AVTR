package com.example.avtr.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.avtr.data.Imple
import com.example.avtr.domain.entity.UserModel
import com.example.avtr.domain.usecase.AddUserUsecase
import com.example.avtr.domain.usecase.GetUserPasswordUsecase
import com.example.avtr.domain.usecase.IssRegistredUsecase

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val imple = Imple(application)
    private var addUserUsecase = AddUserUsecase(imple)
    private val getUserPasswordUsecase = GetUserPasswordUsecase(imple)
    private val issRegistredUsecase = IssRegistredUsecase(imple)
    fun registered(): Boolean {
        return issRegistredUsecase()
    }

    fun passwordUserTest(ps: Int): Boolean {
        return ps == getUserPasswordUsecase()
    }

    fun addUser(userModel: UserModel){
        addUserUsecase(userModel)
    }
}