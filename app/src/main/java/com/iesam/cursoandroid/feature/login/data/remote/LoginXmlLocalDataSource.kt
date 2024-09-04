package com.iesam.cursoandroid.feature.login.data.remote

import android.content.Context

class LoginXmlLocalDataSource(private val context: Context) {

    val sharedPref = context.getSharedPreferences("username", Context.MODE_PRIVATE)

    fun saveUsername(username: String) {
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.commit()
    }
}