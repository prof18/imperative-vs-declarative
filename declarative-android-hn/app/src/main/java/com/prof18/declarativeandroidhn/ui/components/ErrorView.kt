package com.prof18.declarativeandroidhn.ui.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun ErrorView(reason: String, onRefreshClick: (() -> Unit) = {}) {
    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(reason)
            Spacer(Modifier.preferredHeight(16.dp))

            Button(onClick = onRefreshClick) {
                Text(
                    text = "Refresh")
            }
        }
    }
}

@Preview
@Composable
fun ErrorViewPreview() {
    MaterialTheme {
        ErrorView(reason = "Network Error")
    }
}
