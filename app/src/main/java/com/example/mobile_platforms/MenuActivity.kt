package com.example.mobile_platforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun onClickGoTeachersAct(view: View) {
        val intent = Intent(this, TeachersActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoGroupsAct(view: View) {
        val intent = Intent(this, GroupsActivity::class.java)
        startActivity(intent)
    }
}