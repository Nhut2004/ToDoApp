package com.example.todoapp.ui.screens

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.ToDo
import com.example.todoapp.db.ToDoDatabase

class MainApplication : Application() {

    companion object{
        lateinit var ToDoDB : ToDoDatabase
    }

    override fun onCreate(){
        super.onCreate()
        ToDoDB=Room.databaseBuilder(
            applicationContext,
            ToDoDatabase::class.java,
            ToDoDatabase.NAME
        ).build()
    }



}