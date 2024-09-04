package com.iesam.cursoandroid.feature.login.data.remote

class LoginMockRemoteDataSource {

    private val username = "android"
    private val password = "12345"


    // Si fuera API, aquí tendríamos retrofit
    // Si fuera firebase, tendríamos el código suyo específico
    fun validate(username: String, password: String): Boolean {
        return this.username == username && this.password == password
    }
}