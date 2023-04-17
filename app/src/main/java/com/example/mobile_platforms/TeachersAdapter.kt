package com.example.mobile_platforms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_platforms.databinding.TeacherItemBinding

class TeachersAdapter: RecyclerView.Adapter<TeachersAdapter.TeacherHolder>() {
    var teacherList = ArrayList<Teacher>()

        /*
        Teacher("Руслан Красничук",R.drawable.avatar),
        Teacher("Тетяна Дуб",R.drawable.avatar),
        Teacher("Тетяна Смиковчук",R.drawable.avatar)
         */

    class TeacherHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = TeacherItemBinding.bind(item)
        fun bind(teacher: Teacher) = with(binding){
            teacherName.text = teacher.Name
            avaTar.setImageResource(teacher.Image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item, parent, false)
        return TeacherHolder(view)
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: TeacherHolder, position: Int) {
        holder.bind(teacherList[position])
    }
    fun addTeacher(teacher: Teacher){
        teacherList.add(teacher)
        notifyDataSetChanged()
    }
    /*
        fun setList(list: List<Teacher>) {
            teacherList = list
            notifyDataSetChanged()
        }
     */
}