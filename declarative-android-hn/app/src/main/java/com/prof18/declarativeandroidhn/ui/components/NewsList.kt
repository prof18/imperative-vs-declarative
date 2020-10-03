package com.prof18.declarativeandroidhn.ui.components

import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.model.News
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun NewsList(newsList: List<News>) {

    LazyColumnFor(items = newsList) {
        NewsCard(
            news = it
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        NewsList(
            newsList = newsList.take(
                2
            )
        )
    }
}