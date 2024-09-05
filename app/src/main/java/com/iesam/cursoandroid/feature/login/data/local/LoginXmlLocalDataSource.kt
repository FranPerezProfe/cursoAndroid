package com.iesam.cursoandroid.feature.login.data.local

import android.content.Context

class LoginXmlLocalDataSource(private val context: Context) {

    private val KEY_USERNAME = "key_username"

    val sharedPref = context.getSharedPreferences("username", Context.MODE_PRIVATE)

    fun saveUsername(username: String) {
        val editor = sharedPref.edit()
        editor.putString("key_username", username).commit()
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
            remove(KEY_USERNAME)
            commit()
        }
    }

    fun getUsername(): String? {
        return sharedPref.getString(KEY_USERNAME, null)
    }

}