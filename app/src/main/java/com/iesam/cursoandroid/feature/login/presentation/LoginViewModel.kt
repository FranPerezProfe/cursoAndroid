package com.iesam.cursoandroid.feature.login.presentation

import androidx.lifecycle.ViewModel
import com.iesam.cursoandroid.feature.login.domain.DeleteUsernameUseCase
import com.iesam.cursoandroid.feature.login.domain.GetUsernameUseCase
import com.iesam.cursoandroid.feature.login.domain.SaveUsernameUseCase
import com.iesam.cursoandroid.feature.login.domain.SignInUseCase

// La responsabilidad del ViewModel es recoger los datos y elegir el caso de uso a ejecutar
class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val deleteUsernameUseCase: DeleteUsernameUseCase,
    private val getUsernameUseCase: GetUsernameUseCase
) : ViewModel() {



    fun validateClicked(username: String, password: String, isRememberChecked: Boolean): Boolean {

        if (isRememberChecked) {
            saveUsernameUseCase(username)
        } else {
            deleteUsernameUseCase(username)
        }

        // val isValid: Boolean = signInUseCase.invoke(username, password) -> versión verbosa, mejor la siguiente
        return signInUseCase(username, password)
    }


    fun onResumed(): String? {
        return getUsernameUseCase()
    }
}