package com.iesam.cursoandroid.feature.login.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.iesam.cursoandroid.R
import com.iesam.cursoandroid.feature.login.LoginFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory : LoginFactory
    private lateinit var loginViewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.action_validate)
        actionValidate.setOnClickListener {
            // view -> {}
            // Esto anterior es equivalente a utilizar la palabra reservada "it"
            // (it as Button)

            // Log.d("@dev", "Clicked!!");

            // Recupero la información de los input del activity
            val username = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()

            if(loginViewModel.validateClicked(username, password)) {
                Snackbar.make(findViewById<View>(R.id.main),  R.string.msg_login_ok, Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(findViewById<View>(R.id.main),  R.string.msg_login_fails, Snackbar.LENGTH_SHORT).show()
            }







        }
    }

}