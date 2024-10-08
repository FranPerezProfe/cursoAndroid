package com.iesam.cursoandroid.feature.login.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
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
        loginFactory = LoginFactory(this)
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
            val rememberIsChecked = findViewById<CheckBox>(R.id.check_remember).isChecked

            if(loginViewModel.validateClicked(username, password, rememberIsChecked)) {
                Snackbar.make(findViewById<View>(R.id.main),  R.string.msg_login_ok, Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(findViewById<View>(R.id.main),  R.string.msg_login_fails, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getSavedUser()
    }

    private fun getSavedUser() {

        // Mejor versión -> hay que evitar que se repinte la vista si hay un nulo
        loginViewModel.onResumed()?.let {
            findViewById<EditText>(R.id.input_username).setText(it)
        }

        // Más verboso
        /*loginViewModel.onResumed()?.let { username ->
            findViewById<EditText>(R.id.input_username).setText(username)
        }*/
    }
}