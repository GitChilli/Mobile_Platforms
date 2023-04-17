package com.example.mobile_platforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = intent.getStringExtra("login")
        if (login != null) {
            Toast.makeText(this, "Welcome, $login!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickGoSecondActivity (view : View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoThirdActivity (view : View) {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoLoginActivity (view : View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}