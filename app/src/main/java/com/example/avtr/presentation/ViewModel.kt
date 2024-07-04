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
     val getUserPasswordUsecase = GetUserPasswordUsecase(imple)
    private val issRegistredUsecase = IssRegistredUsecase(imple)
    fun registered(): Boolean {
        return issRegistredUsecase()
    }

    fun passwordUserTest(ps: List<Int>): Boolean {
        val userPasswordUsecase = getUserPasswordUsecase()
        val oneData = userPasswordUsecase / 1000 //2 345
        val twoDatax = userPasswordUsecase % 1000
        val twoData=twoDatax/ 100 // 3 45
        val threeData = twoData / 10 // 4 5
        val fourData = twoData % 10 // 4 5

        return ps[0]==oneData
    }

    fun addUser(userModel: UserModel) {
        addUserUsecase(userModel)
    }
}