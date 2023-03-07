package com.example.newsapi.modell

data class News (
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
        )