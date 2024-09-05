package com.iesam.cursoandroid.feature.login

import android.content.Context
import com.iesam.cursoandroid.feature.login.data.LoginDataRepository
import com.iesam.cursoandroid.feature.login.data.remote.LoginMockRemoteDataSource
import com.iesam.cursoandroid.feature.login.data.remote.LoginXmlLocalDataSource
import com.iesam.cursoandroid.feature.login.domain.DeleteUsernameUseCase
import com.iesam.cursoandroid.feature.login.domain.LoginRepository
import com.iesam.cursoandroid.feature.login.domain.SaveUsernameUseCase
import com.iesam.cursoandroid.feature.login.domain.SignInUseCase
import com.iesam.cursoandroid.feature.login.presentation.LoginViewModel

class LoginFactory(private val context: Context) {

    private val loginMockRemoteDataSource:  LoginMockRemoteDataSource = provideLoginRemoteDataSource();
    private val loginXmlLocalDataSource:  LoginXmlLocalDataSource = provideLoginXmlRemoteDataSource()
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    private val signInUseCase: SignInUseCase = provideSignInUseCase()
    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUseCase()
    private val deleteUsernameUseCase: DeleteUsernameUseCase = provideDeleteUsernameUseCase()




    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase, saveUsernameUseCase, deleteUsernameUseCase)
    }

    private fun provideLoginRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository {
        return LoginDataRepository(loginMockRemoteDataSource, loginXmlLocalDataSource);
    }

    private fun provideLoginXmlRemoteDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }


    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase {
        return SaveUsernameUseCase(loginRepository)
    }

    private fun provideDeleteUsernameUseCase(): DeleteUsernameUseCase {
        return DeleteUsernameUseCase(loginRepository)
    }
}