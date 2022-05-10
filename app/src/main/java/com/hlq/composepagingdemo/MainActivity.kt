package com.hlq.composepagingdemo

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.hlq.composepagingdemo.bean.DemoReqData
import com.hlq.composepagingdemo.ui.theme.ComposePagingDemoTheme
import com.hlq.composepagingdemo.viewmodel.MainActivityViewModel
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePagingDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val mainViewmodel: MainActivityViewModel = viewModel()
    val data = mainViewmodel.getData().collectAsLazyPagingItems()
    Column {
        LazyColumn() {
            items(items = data) { item ->
                Message(data = item)
            }

            val TAG = "加载状态"

            if (data.loadState.refresh is LoadState.Loading) {
                Log.d(TAG, "正在加载")
            } else if (data.loadState.refresh is LoadState.Error) {
                when ((data.loadState.refresh as LoadState.Error).error) {
                    is IOException -> {
                        Log.d(TAG, "网络未连接，可在这里放置失败视图")
                    }
                    else -> {
                        Log.d(TAG, "网络未连接，其他异常")
                    }
                }
            }
        }
    }


}

@Composable
fun Message(data: DemoReqData.DataBean.DatasBean?) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
            .fillMaxSize(), elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "作者：${data?.author}"
            )
            Text(text = "${data?.title}")
        }
    }

}




