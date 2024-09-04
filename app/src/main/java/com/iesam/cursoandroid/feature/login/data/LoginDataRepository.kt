package com.iesam.cursoandroid.feature.login.data

import com.iesam.cursoandroid.feature.login.data.remote.LoginMockRemoteDataSource
import com.iesam.cursoandroid.feature.login.data.remote.LoginXmlLocalDataSource
import com.iesam.cursoandroid.feature.login.domain.LoginRepository

class LoginDataRepository(private val remoteDataSource: LoginMockRemoteDataSource, private val localDataSource: LoginXmlLocalDataSource) : LoginRepository {

    override fun isValid(username: String, password: String): Boolean {
        return remoteDataSource.validate(username, password)
    }

    override fun saveUsername(username: String) {
        localDataSource.saveUsername(username)
    }

}