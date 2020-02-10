package com.prof18.declarativeandroidhn.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun LoadingView() {
    Center {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun LoadingViewPreview() {
    MaterialTheme {
        LoadingView()
    }
}
