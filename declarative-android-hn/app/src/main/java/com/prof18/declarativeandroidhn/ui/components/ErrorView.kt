package com.prof18.declarativeandroidhn.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun ErrorView(reason: String, onRefreshClick: (() -> Unit)?) {
    Center {
        Column(
            modifier = Spacing(16.dp),
            crossAxisAlignment = CrossAxisAlignment.Center
        ) {
            Text(reason)
            HeightSpacer(height = 16.dp)

            Button(onClick = onRefreshClick) {
                Text(text = "Refresh")
            }
        }
    }
}

@Preview
@Composable
fun ErrorViewPreview() {
    MaterialTheme {
        ErrorView(reason = "Network Error", onRefreshClick = null)
    }
}
