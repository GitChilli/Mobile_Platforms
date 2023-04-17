package com.example.mobile_platforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickGoSecondActivity (view : View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoThirdActivity (view : View) {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoMenuActivity (view : View) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

}