package com.iesam.cursoandroid.feature.login.domain

interface LoginRepository {

    fun isValid(username: String, password: String): Boolean
    fun saveUsername(username: String)
    fun deleteUsername(username: String)
    fun getUsername(): String?

}