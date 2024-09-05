package com.iesam.cursoandroid.feature.login.data.remote

import android.content.Context

class LoginXmlLocalDataSource(private val context: Context) {

    val sharedPref = context.getSharedPreferences("username", Context.MODE_PRIVATE)

    fun saveUsername(username: String) {
        val editor = sharedPref.edit()
        editor.putString("key_username", username)
        editor.commit()
    }


    // En Java
    /*fun deleteUsername(username: String) {
        val editor = sharedPref.edit()
        // editor.clear()
        editor.remove("key_username")
        editor.commit()
    }*/

    // En kotlin ---> Scope function: apply
    fun deleteUsername(username: String) {
        sharedPref.edit().apply {
            remove("key_username")
            commit()
        }
    }

}