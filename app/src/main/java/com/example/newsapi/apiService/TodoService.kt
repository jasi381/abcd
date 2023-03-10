package com.example.newsapi.apiService

import com.example.newsapi.data.TodosResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface TodoService {

    suspend fun getTodos():List<TodosResponse>
    companion object{
        fun create():TodoService{
            return TodoServiceImpl(
                client = HttpClient(Android){
                    install(JsonFeature){
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}
