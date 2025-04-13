package com.example.todoapp.db


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.data.ToDo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface ToDoDAO {
    @Query("Select * from ToDo")
    fun getAllToDo(): Flow<List<ToDo>>

    @Insert
    fun addToDo(toDo: ToDo)

    @Query("Delete from todo where id = :id")
    fun deleteToDo(id: Int)

}