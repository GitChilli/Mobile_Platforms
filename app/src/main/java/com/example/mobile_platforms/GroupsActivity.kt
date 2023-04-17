package com.example.mobile_platforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_platforms.databinding.ActivityGroupsBinding
import com.example.mobile_platforms.databinding.ActivityTeachersBinding

class GroupsActivity : AppCompatActivity() {

    lateinit var binding: ActivityGroupsBinding
    private val adapter = TeachersAdapter()
    private val imageAvat = R.drawable.avatar
    private val nameT = listOf("П-41", "П-42")
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcViewGrp.layoutManager = LinearLayoutManager(this@GroupsActivity)
            rcViewGrp.adapter = adapter


            buttonAddGrp.setOnClickListener{
                if (index >= 1) {buttonAddGrp.visibility = View.INVISIBLE}
                val teacher = Teacher(nameT[index], imageAvat)
                adapter.addTeacher(teacher)
                //adapter.teacherList.add(Teacher(nameT[index],imageAvat))
                index++
            }

        }
    }
}