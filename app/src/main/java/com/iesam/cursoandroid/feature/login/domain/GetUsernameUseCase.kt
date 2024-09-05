package com.iesam.cursoandroid.feature.login.domain

class GetUsernameUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(): String? {
        return loginRepository.getUsername()
    }
}