package com.prof18.declarativeandroidhn.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.prof18.declarativeandroidhn.R
import com.prof18.declarativeandroidhn.data.model.NewsState
import com.prof18.declarativeandroidhn.ui.components.ErrorView
import com.prof18.declarativeandroidhn.ui.components.LoadingView
import com.prof18.declarativeandroidhn.ui.components.NewsList

@Composable
fun HomeScreen(viewModel: MainViewModel) {

    val appState by viewModel.appState.observeAsState()

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = context.getString(R.string.app_name)
                    )
                }
            )
        },
        content = {
            when (appState?.newsState) {
                NewsState.Loading -> {
                    LoadingView()
                }
                is NewsState.Success -> {
                    val successState = appState?.newsState as NewsState.Success
                    NewsList(
                        newsList = successState.news
                    )
                }
                is NewsState.Error -> {
                    val errorState = appState?.newsState as NewsState.Error
                    ErrorView(
                        reason = errorState.reason,
                        onRefreshClick = { viewModel.loadData() })
                }
            }
        }
    )
}