package com.prof18.declarativeandroidhn.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.FlexColumn
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.model.NewsState
import com.prof18.declarativeandroidhn.data.newsList
import com.prof18.declarativeandroidhn.ui.components.ErrorView
import com.prof18.declarativeandroidhn.ui.components.LoadingView
import com.prof18.declarativeandroidhn.ui.components.NewsList

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            MaterialTheme {
                FlexColumn {
                    inflexible {
                        TopAppBar(
                            title = { Text("Declarative Android HN") }
                        )
                    }
                    flexible(1f) {
                        when (viewModel.appState.newsState) {
                            NewsState.Loading -> {
                                LoadingView()
                            }
                            is NewsState.Success -> {
                                val successState = viewModel.appState.newsState as NewsState.Success

                                NewsList(
                                    newsList = successState.news,
                                    context = this@MainActivity
                                )
                            }
                            is NewsState.Error -> {
                                val errorState = viewModel.appState.newsState as NewsState.Error
                                ErrorView(reason = errorState.reason)
                            }
                        }

                    }
                }
            }
        }

        viewModel.loadData()
    }


}


@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        NewsList(
            newsList = newsList,
            context = null
        )
    }
}

