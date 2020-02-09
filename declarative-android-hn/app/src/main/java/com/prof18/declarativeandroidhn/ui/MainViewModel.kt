package com.prof18.declarativeandroidhn.ui

import android.os.Handler
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.declarativeandroidhn.data.model.AppState
import com.prof18.declarativeandroidhn.data.model.NewsState
import com.prof18.declarativeandroidhn.data.newsList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val appState = AppState(newsState = NewsState.Loading)

    fun loadData() {

        viewModelScope.launch {
            delay(2000)

            appState.newsState = NewsState.Error("Random Error")

            delay(2000)

            appState.newsState = NewsState.Success(newsList)
        }
    }


}