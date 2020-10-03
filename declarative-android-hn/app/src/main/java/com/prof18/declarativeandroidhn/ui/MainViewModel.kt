package com.prof18.declarativeandroidhn.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.declarativeandroidhn.data.model.AppState
import com.prof18.declarativeandroidhn.data.model.NewsState
import com.prof18.declarativeandroidhn.data.newsList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _appState = MutableLiveData<AppState>(AppState(NewsState.Loading))
    val appState: LiveData<AppState>
        get() = _appState

    init {
        generateError()
    }

    fun loadData() {
        viewModelScope.launch {
            _appState.value = AppState(NewsState.Loading)
            delay(2000)
            _appState.value = AppState(NewsState.Success(newsList))
        }
    }

    private fun generateError() {
        viewModelScope.launch {
            delay(2000)
            _appState.value =
                AppState(NewsState.Error("This is a generated error only to try an error state"))
        }
    }
}