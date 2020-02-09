package com.prof18.declarativeandroidhn.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.model.News
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun NewsCard(news: News, context: Context?) {
    Card(shape = RoundedCornerShape(16.dp)) {
        Ripple(bounded = true) {
            Clickable(onClick = {
                context?.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com")
                    )
                )
            }) {
                Container {
                    Column {
                        Text(news.title)
                        Text(news.getStringTime())
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    MaterialTheme {
        NewsCard(
            news = newsList[1],
            context = null
        )
    }
}

