package com.prof18.declarativeandroidhn.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.sp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.tooling.preview.Preview
import com.prof18.declarativeandroidhn.data.model.News
import com.prof18.declarativeandroidhn.data.newsList

@Composable
fun NewsCard(news: News, context: Context?) {
    Card(shape = RoundedCornerShape(16.dp), elevation = 8.dp) {
        Ripple(bounded = true) {
            Clickable(onClick = {
                context?.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com")
                    )
                )
            }) {
                Container {
                    Column(ExpandedWidth wraps Spacing(16.dp)) {
                        Text(
                            text = news.title,
                            style = TextStyle(fontSize = 18.sp)
                        )
                        HeightSpacer(height = 9.dp)
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
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    MaterialTheme {
        NewsCard(
            news = newsList[1],
            context = null
        )
    }
}

