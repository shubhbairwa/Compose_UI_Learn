package com.shubh.compose.quotes.screens

import android.content.res.Resources.Theme
import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.sweepGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubh.compose.R
import com.shubh.compose.model.data.Quote


@Composable
fun QuoteItem(quote: Quote, onclick: (quote: Quote) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp), //adding elevation in card
        modifier = Modifier

            .clickable { onclick(quote) }

            .padding(8.dp)
//            .border(
//                1.dp,
//                colorResource(id = R.color.black),// it will add color from color.xml file
//                RoundedCornerShape(8.dp)
//            ) //for stroke in card
            .border(1.dp, color = MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))

    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSecondary)
                .padding(16.dp)
        ) {
            Image(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Quote icon",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Blue)


            )
            Spacer(modifier = Modifier.padding(4.dp)) //act like margin
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFF868686))
                        .fillMaxWidth(.4f)
                        .height(1.dp) //it will make divider like UI
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(4.dp)

                )

            }
        }

    }
}






