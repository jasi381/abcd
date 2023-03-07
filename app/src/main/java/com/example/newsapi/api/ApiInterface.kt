package com.example.newsapi.api

import com.example.newsapi.modell.Article
import com.example.newsapi.modell.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "11bbedc333bc43c9bf77d18ef103c10d"



//interface ApiInterface {
//
//    @GET("v2/everything?apiKey=$API_KEY&lang=en&q=bitcoin")
//    fun getHeadlines(): Call<News>
//}
//object RetrofitServices{
//
//    val retrofitInstance :ApiInterface
//
//    init {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        retrofitInstance = retrofit.create(ApiInterface::class.java)
//    }
//
//}
//
//val retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//
//val apiService = retrofit.create(ApiService::class.java)
//
//interface ApiService {
//    @GET("v2/everything?apiKey=$API_KEY&lang=en&q=bitcoin")
//    suspend fun getData(): Call<News>
//}

interface ApiService {

    @GET("v2/everything?apiKey=$API_KEY&lang=en&q=bitcoin")
    suspend fun getNews() :List<News>


    companion object{

        var apiService :ApiService?=null
        fun getInstance():ApiService{

            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }

    }
}
