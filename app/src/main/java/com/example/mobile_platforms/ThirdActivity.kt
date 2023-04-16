package com.example.mobile_platforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }

    fun onClickGoMain (view : View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoSecondActivity (view : View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

}