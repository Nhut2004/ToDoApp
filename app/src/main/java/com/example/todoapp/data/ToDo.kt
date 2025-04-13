package com.example.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date
@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var  createAt: Date
)


