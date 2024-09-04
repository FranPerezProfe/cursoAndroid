package com.iesam.cursoandroid.feature.login

import com.iesam.cursoandroid.feature.login.data.LoginDataRepository
import com.iesam.cursoandroid.feature.login.data.remote.LoginMockRemoteDataSource
import com.iesam.cursoandroid.feature.login.domain.LoginRepository
import com.iesam.cursoandroid.feature.login.domain.SignInUseCase
import com.iesam.cursoandroid.feature.login.presentation.LoginViewModel

class LoginFactory {

    private val loginMockRemoteDataSource:  LoginMockRemoteDataSource = provideLoginRemoteDataSource();
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    private val signInUseCase: SignInUseCase = provideSignInUseCase()


    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)
    }

    private fun provideLoginRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository {
        return LoginDataRepository(loginMockRemoteDataSource);
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }
}