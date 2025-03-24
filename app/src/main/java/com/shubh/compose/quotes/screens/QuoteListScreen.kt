package com.shubh.compose.quotes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shubh.compose.model.data.Quote
import com.shubh.compose.ui.theme.ComposeTheme


@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    var theme = remember { mutableStateOf(false) }
    ComposeTheme(theme.value) {

        Column(Modifier.background(color = MaterialTheme.colorScheme.background)) {
            Text(
                text = "Quote List",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp, 24.dp)
                    .fillMaxWidth(1f),
                textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.primary


            )
            Button(onClick = {
                theme.value = !theme.value
            }) {
                Text(text = "theme")

            }
            QuoteList(data = data, onClick)


        }

    }


}