package com.prof18.declarativeandroidhn.data.model

sealed class NewsState {
    object Loading: NewsState()
    class Success(val news: List<News>): NewsState()
    class Error(val reason: String): NewsState()
}