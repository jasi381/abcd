package com.example.newsapi.data

import kotlinx.serialization.Serializable

@Serializable
data class TodosResponse(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)
