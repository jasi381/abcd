package com.example.newsapi.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.api.ApiService
import com.example.newsapi.modell.News
import kotlinx.coroutines.launch

class NewsViewModel :ViewModel() {
    
//    val newsLiveData = MutableLiveData<News>()
    
//
//    fun getNews(){
//        val response = RetrofitServices.retrofitInstance.getHeadlines()
//
//        response.enqueue(object : Callback<News?> {
//            override fun onResponse(call: Call<News?>, response: Response<News?>) {
//                if (response.isSuccessful){
//                    newsLiveData.value = response.body()
//                    Log.d("Success", "${response.body()!!.articles} ")
//                }
//            }
//
//            override fun onFailure(call: Call<News?>, t: Throwable) {
//                Log.d("Failure", "${t.message}")
//            }
//        })
//    }


    var newsListResponse :List<News> by mutableStateOf(listOf())
    var errorMessage :String by mutableStateOf("")


    fun getNewsList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val response = apiService.getNews()
                newsListResponse = response
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}