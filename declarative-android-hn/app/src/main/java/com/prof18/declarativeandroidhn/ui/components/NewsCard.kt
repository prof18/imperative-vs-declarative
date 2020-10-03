package com.prof18.declarativeandroidhn.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.model.News
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun NewsCard(news: News) {
    val context = ContextAmbient.current

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        modifier = Modifier
            .clickable(onClick = {
                if (news.url != null) {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(news.url)
                        )
                    )
                }
            })
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = news.title,
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(Modifier.preferredHeight(9.dp))
            Text(
                text = news.getStringTime(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    MaterialTheme {
        NewsCard(
            news = newsList[1]
        )
    }
}

