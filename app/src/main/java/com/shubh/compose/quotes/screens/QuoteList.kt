package com.shubh.compose.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.shubh.compose.model.data.Quote


@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    LazyColumn(content = {

        items(data) {
            QuoteItem(quote = it,onClick)
        }
    })
}