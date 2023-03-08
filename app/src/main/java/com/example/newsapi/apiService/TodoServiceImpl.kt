package com.example.newsapi.apiService

import com.example.newsapi.data.TodosResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*


const val BASE_URL = "https://jsonplaceholder.typicode.com"
const val TODO_URL = "$BASE_URL/todos"

class TodoServiceImpl(
    private val client :HttpClient
):TodoService{

    override suspend fun getTodos(): List<TodosResponse> {
        return  try {
            client.get {
                url(TODO_URL)
            }
        }catch (e:RedirectResponseException){
            println(e.response.status.description)
            emptyList()
        }
        catch (e:Exception){
            println(e.message)
            emptyList()
        }
    }
}