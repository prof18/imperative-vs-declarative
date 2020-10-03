package com.prof18.declarativeandroidhn.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.newsList
import com.prof18.declarativeandroidhn.ui.components.NewsList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                HomeScreen()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        NewsList(
            newsList = newsList
        )
    }
}

