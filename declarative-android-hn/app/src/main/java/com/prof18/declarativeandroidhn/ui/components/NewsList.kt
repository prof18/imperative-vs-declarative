package com.prof18.declarativeandroidhn.ui.components

import android.content.Context
import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.model.News
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun NewsList(newsList: List<News>, context: Context?) {
    VerticalScroller {
        Column {
            newsList.forEach {
                NewsCard(
                    news = it,
                    context = context
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        NewsList(
            newsList = newsList.take(
                2
            ), context = null
        )
    }
}