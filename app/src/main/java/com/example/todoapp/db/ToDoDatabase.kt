package com.example.todoapp.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp.data.ToDo

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(Converters::class)
abstract class ToDoDatabase: RoomDatabase() {

    companion object{
        const val NAME = "TODO_DB"
    }

    abstract fun getToDoDAO() : ToDoDAO

}