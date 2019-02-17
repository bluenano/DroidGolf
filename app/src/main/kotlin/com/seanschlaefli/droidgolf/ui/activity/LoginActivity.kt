package com.seanschlaefli.droidgolf.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.seanschlaefli.droidgolf.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)

        findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()
            // make network call to API to verify login
        }

        findViewById<Button>(R.id.user_sign_up_button).setOnClickListener {
            startActivity(SignUpActivity.newIntent(this@LoginActivity))
        }

        /*
        findViewById<Button>(R.id.forgot_password_text_view).setOnClickListener {
            // dialog for forgotten password?
        }
        */

        findViewById<Button>(R.id.google_sign_in_button).setOnClickListener {
            // implement google sign in?
            Toast.makeText(this,
                "This feature is not available yet!",
                Toast.LENGTH_SHORT).show()
        }

    }
}
