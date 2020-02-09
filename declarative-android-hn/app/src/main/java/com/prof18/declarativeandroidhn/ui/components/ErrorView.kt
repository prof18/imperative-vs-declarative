package com.prof18.declarativeandroidhn.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun ErrorView(reason: String) {
    Text(reason)
}

@Preview
@Composable
fun ErrorViewPreview() {
    MaterialTheme {
        ErrorView(reason = "Network Error")
    }
}
