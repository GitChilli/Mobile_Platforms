package com.example.mobile_platforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_platforms.databinding.ActivityTeachersBinding

class TeachersActivity : AppCompatActivity() {
    lateinit var binding: ActivityTeachersBinding
    private val adapter = TeachersAdapter()
    private val imageAvat = R.drawable.avatar
    private val nameT = listOf("Руслан Красничук", "Іван Гоянюк", "Тетяна Смиковчук")
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeachersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcViewTea.layoutManager = LinearLayoutManager(this@TeachersActivity)
            rcViewTea.adapter = adapter


            buttonAdd.setOnClickListener{
                if (index > 1) {buttonAdd.visibility = View.INVISIBLE}
                val teacher = Teacher(nameT[index], imageAvat)
                adapter.addTeacher(teacher)
                //adapter.teacherList.add(Teacher(nameT[index],imageAvat))
                index++
            }

        }
    }
        /*
        fun teacherList(){
            val listT = findViewById<RecyclerView>(R.id.rcViewTea)
            var listMas = arrayOf("Руслан Красничук","Тетяна Дуб", "Тетяна Смиковчук")
            listT.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listMas)
        }
         */
}