package com.iesam.cursoandroid.feature.login.presentation

import androidx.lifecycle.ViewModel
import com.iesam.cursoandroid.feature.login.domain.SignInUseCase

// La responsabilidad del ViewModel es recoger los datos y elegir el caso de uso a ejecutar
class LoginViewModel(private val signInUseCase: SignInUseCase) : ViewModel()   {

    fun validateClicked(username: String, password: String): Boolean {
        // val isValid: Boolean = signInUseCase.invoke(username, password) -> versión verbosa, mejor la siguiente
        return signInUseCase(username, password)


    }
}