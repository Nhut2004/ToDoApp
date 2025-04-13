package com.example.todoapp.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.ToDo
import com.example.todoapp.ui.screens.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel : ViewModel() {

    val todoDAO = MainApplication.ToDoDB.getToDoDAO()
    val todoList = todoDAO.getAllToDo().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    @RequiresApi(Build.VERSION_CODES.O)
    fun addToDo(title: String) {

        viewModelScope.launch(Dispatchers.IO) {
            todoDAO.addToDo(ToDo(title = title, createAt = Date.from(Instant.now())))
        }
    }

    fun deleteToDo(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            todoDAO.deleteToDo(id)
        }


    }

}
