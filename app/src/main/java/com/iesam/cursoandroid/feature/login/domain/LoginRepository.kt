package com.iesam.cursoandroid.feature.login.domain

interface LoginRepository {

    fun isValid(username: String, password: String): Boolean

}