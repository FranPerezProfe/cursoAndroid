package com.iesam.cursoandroid.feature.login.presentation

import androidx.lifecycle.ViewModel
import com.iesam.cursoandroid.feature.login.domain.SaveUsernameUseCase
import com.iesam.cursoandroid.feature.login.domain.SignInUseCase

// La responsabilidad del ViewModel es recoger los datos y elegir el caso de uso a ejecutar
class LoginViewModel(private val signInUseCase: SignInUseCase, private val saveUsernameUseCase: SaveUsernameUseCase) : ViewModel()   {

    fun validateClicked(username: String, password: String, isRememberChecked: Boolean): Boolean {

        if(isRememberChecked) {
            saveUsernameUseCase(username)
        }

        // val isValid: Boolean = signInUseCase.invoke(username, password) -> versión verbosa, mejor la siguiente
        return signInUseCase(username, password)
    }
}