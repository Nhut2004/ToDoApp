package com.example.todoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import java.time.Instant
import java.util.Date

object ToDoManager {

    private val todoList = mutableStateListOf<ToDo>()


    fun getAllToDo() : List<ToDo>{
        return todoList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addToDo(title: String){
        todoList.add(ToDo(System.currentTimeMillis().toInt(),title, Date.from(Instant.now())))
    }

    fun deleteToDo(id: Int){
        todoList.removeIf {
            it.id == id
        }
    }
}