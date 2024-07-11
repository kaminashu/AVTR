package com.example.avtr.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.avtr.data.Imple
import com.example.avtr.domain.entity.UserModel
import com.example.avtr.domain.usecase.AddUserUsecase
import com.example.avtr.domain.usecase.GetUserPasswordUsecase
import com.example.avtr.domain.usecase.IssRegistredUsecase

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val imple = Imple(application)
    private var addUserUsecase = AddUserUsecase(imple)
    val getUserPasswordUsecase = GetUserPasswordUsecase(imple)
    private val issRegistredUsecase = IssRegistredUsecase(imple)
    private val liveData = MutableLiveData<List<Int>>()
    val psLiveData: LiveData<List<Int>> get() = liveData
    fun registered(): Boolean {
        return issRegistredUsecase()
    }

    fun passwordUserTest(): Int {
        val userPasswordUsecase = getUserPasswordUsecase()
        return userPasswordUsecase
    }

    fun addUser(userModel: UserModel) {
        addUserUsecase(userModel)
    }

    fun addListPassword(list: List<Int>) {
        liveData.value = list.toList()
    }
}