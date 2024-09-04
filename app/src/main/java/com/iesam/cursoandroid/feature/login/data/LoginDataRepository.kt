package com.iesam.cursoandroid.feature.login.data

import com.iesam.cursoandroid.feature.login.data.remote.LoginMockRemoteDataSource
import com.iesam.cursoandroid.feature.login.domain.LoginRepository

class LoginDataRepository(private val remoteDataSource: LoginMockRemoteDataSource) : LoginRepository {
    override fun isValid(username: String, password: String): Boolean {
        return remoteDataSource.validate(username, password)
    }

}