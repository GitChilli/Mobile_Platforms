package com.example.mobile_platforms

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var emailEditText: EditText
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailEditText = findViewById(R.id.email_edit_text)
        loginEditText = findViewById(R.id.login_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Перевірка довжини логіну та паролю
            if (login.length < 6) {
                loginEditText.error = "Логін повинен містити не менше 6 символів"
                return@setOnClickListener
            }
            if (password.length < 8) {
                passwordEditText.error = "Пароль повинен містити не менше 8 символів"
                return@setOnClickListener
            }

            // Перевірка, чи логін не зайнятий
            val userExists = sharedPreferences.getString(login, null)
            if (userExists != null) {
                loginEditText.error = "Користувач з таким логіном вже існує"
                return@setOnClickListener
            }

            saveCredentials(email, login, password)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("login", login)
            startActivity(intent)
            finish()
        }
    }

    private fun saveCredentials(email: String, login: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString(login, password)
        editor.apply()
    }
}
