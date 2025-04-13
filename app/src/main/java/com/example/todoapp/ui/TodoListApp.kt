package com.example.todoapp.ui


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.todoapp.R
import com.example.todoapp.data.ToDo
import java.text.SimpleDateFormat
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListApp(viewModel: ToDoViewModel ) {
    val todoList by viewModel.todoList.collectAsStateWithLifecycle()
    var inputText by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                }
            )

            Button(
                onClick = {
                    viewModel.addToDo(inputText)
                    inputText=""
                }
            ) {
                Text("Add")
            }

        }

        todoList?.let {
            LazyColumn {
                itemsIndexed(todoList) { index, item ->
                    ToDoItem(item = item, onDelete = {
                        viewModel.deleteToDo(item.id)
                    })
                }
            }
        }

    }
}


@Composable
fun ToDoItem(item: ToDo,onDelete : () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = SimpleDateFormat("HH:mm:aa dd/mm", Locale.ENGLISH).format(item.createAt),
                fontSize = 25.sp,
                color = Color.Red
            )
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold
            )
        }

        IconButton(
            onClick = onDelete

        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_delete_24),
                contentDescription = "Button Delete",
            )
        }

    }
}
