package com.prof18.declarativeandroidhn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.FlexColumn
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.newsList
import com.prof18.declarativeandroidhn.ui.NewsCard
import com.prof18.declarativeandroidhn.ui.NewsList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                FlexColumn {
                    inflexible {
                        TopAppBar(
                            title = { Text("Declarative Android HN") }
                        )
                    }
                    flexible(1f) {
                        NewsList(
                            newsList = newsList,
                            context = this@MainActivity
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        NewsCard(
            news = newsList[1],
            context = null
        )
    }
}

