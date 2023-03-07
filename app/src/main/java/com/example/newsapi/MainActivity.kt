package com.example.newsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.newsapi.ui.theme.NewsApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
//                    MainScreen()
//                    val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
//
//                    viewModel.getNews()
//
//                    viewModel.newsLiveData.observe(this,{
//                        Text(text = it.articles[0].title)
//                    })
                }
            }
        }
    }
}

//@Composable
//fun NewsScreen() {
//    Surface(modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colors.background) {
//        val viewModel = ViewModelProvider(LocalContext.current as AppCompatActivity)[NewsViewModel::class.java]
//
//        viewModel.getNews()
//
//        viewModel.newsLiveData.observe(LocalLifecycleOwner.current) {
//            Text(text = it.articles[0].title)
//        }
//    }
//}

//
//@Composable
//fun NewsScreen() {
//    val viewModel = viewModel<NewsViewModel>()
//
//    LaunchedEffect(viewModel) {
//        viewModel.getNews()
//    }
//
//    val newsData = viewModel.newsLiveData.observeAsState()
//
//    Surface(modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colors.background) {
//
//        newsData.value?.let {
//            Text(text = it.articles[0].title)
//        }
//    }
//}


//@Composable
//fun DataList(apiService: ApiService) {
//    var data by remember { mutableStateOf(emptyList<Article>()) }
//
//    LaunchedEffect(Unit) {
//        data = apiService.getData()
//    }
//
//    LazyColumn {
//        items(data.size) { item ->
//            Text(text = item.toString())
//        }
//    }
//}
//
//@Composable
//fun MainScreen() {
//    val apiService = remember {
//        retrofit.create(ApiService::class.java)
//    }
//
//    DataList(apiService)
//}





