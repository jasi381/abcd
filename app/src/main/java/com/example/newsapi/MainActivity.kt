package com.example.newsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapi.apiService.TodoService
import com.example.newsapi.data.TodosResponse
import com.example.newsapi.ui.theme.NewsApiTheme

class MainActivity : ComponentActivity() {
    private val service = TodoService.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todos = produceState<List<TodosResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = service.getTodos()

                }
            )

            NewsApiTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    LazyColumn{
                        items(todos.value){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = it.title,
                                    style = MaterialTheme.typography.h5,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = it.completed.toString(),
                                    style = MaterialTheme.typography.h5,
                                    fontSize = 16.sp
                                )
                                Divider(
                                    color = Color.Black,
                                    thickness = 1.dp
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}






