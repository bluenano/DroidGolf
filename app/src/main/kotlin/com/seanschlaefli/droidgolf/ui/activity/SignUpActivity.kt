package com.seanschlaefli.droidgolf.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.seanschlaefli.droidgolf.R

class SignUpActivity: AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var firstnameEditText: EditText
    private lateinit var lastnameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailEditText = findViewById(R.id.email_sign_up_edit_text)
        passwordEditText = findViewById(R.id.password_sign_up_edit_text)
        usernameEditText = findViewById(R.id.username_edit_text)
        firstnameEditText = findViewById(R.id.firstname_edit_text)
        lastnameEditText = findViewById(R.id.lastname_edit_text)

        findViewById<Button>(R.id.user_sign_up_button).setOnClickListener {
            // send info to API over HTTP
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            var intent = Intent()
            intent.setClass(context, SignUpActivity::class.java)
            return intent
        }
    }
}