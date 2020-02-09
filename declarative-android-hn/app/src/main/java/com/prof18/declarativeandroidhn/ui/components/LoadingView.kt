package com.prof18.declarativeandroidhn.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun LoadingView() {
    Text("Loading")
}

@Preview
@Composable
fun LoadingViewPreview() {
    MaterialTheme {
        LoadingView()
    }
}
