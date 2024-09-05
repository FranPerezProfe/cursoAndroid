package com.iesam.cursoandroid.feature.login.domain

class DeleteUsernameUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(username: String) {
        loginRepository.deleteUsername(username)
    }
}