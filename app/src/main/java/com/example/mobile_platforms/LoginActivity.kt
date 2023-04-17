package com.example.mobile_platforms

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginEditText = findViewById(R.id.login_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (checkCredentials(login, password)) {
                saveCredentials(login, password)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("login", login)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrect login or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkCredentials(login: String, password: String): Boolean {

        if(login != ""){
            if(sharedPreferences.contains(login)){
                if(sharedPreferences.getString(login,"") == password ){
                    return true

                }
            }
        }
        return false
    }

    private fun saveCredentials(login: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("login", login)
        editor.putString("password", password)
        editor.apply()
    }

    fun OnClickRegisterActivity(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}