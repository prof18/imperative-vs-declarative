package com.prof18.declarativeandroidhn.data.model

import java.text.SimpleDateFormat
import java.util.*

data class News(
    val by: String,
    val id: Long,
    val score: Int,
    val text: String? = null,
    val time: Long,
    val title: String,
    val type: String,
    val url: String? = null
) {

    fun getStringTime(): String {
        val formatter = SimpleDateFormat("d MMM yyyy", Locale.getDefault())
        return formatter.format(Date(time*1000))

    }

}
