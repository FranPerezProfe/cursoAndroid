package com.iesam.cursoandroid.feature.login.domain

class SaveUsernameUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(username: String) {
        loginRepository.saveUsername(username)
    }
}