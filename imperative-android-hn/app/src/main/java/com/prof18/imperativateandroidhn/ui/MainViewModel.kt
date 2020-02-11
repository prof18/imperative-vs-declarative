package com.prof18.imperativateandroidhn.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.imperativateandroidhn.data.model.AppState
import com.prof18.imperativateandroidhn.data.model.NewsState
import com.prof18.imperativateandroidhn.data.newsList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _appState = MutableLiveData<AppState>()
    val appState: LiveData<AppState>
        get() = _appState


    fun loadData() {
        viewModelScope.launch {
            _appState.value = AppState(newsState = NewsState.Loading)
            delay(2000)
            _appState.value = AppState(newsState = NewsState.Success(newsList))
        }
    }

    fun generateError() {
        viewModelScope.launch {
            delay(2000)
            _appState.value =  AppState(newsState = NewsState.Error("This is a generated error only to try an error state"))
        }
    }

}