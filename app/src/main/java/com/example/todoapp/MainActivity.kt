package com.example.todoapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.ui.ToDoViewModel
import com.example.todoapp.ui.TodoListApp
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class]
        setContent {
            TodoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoListApp(toDoViewModel)
                }
            }
        }
    }
}

