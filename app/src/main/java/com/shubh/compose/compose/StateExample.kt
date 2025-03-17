package com.shubh.compose.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubh.compose.R


private const val TAG = "StateExample"


@Preview(showSystemUi = true)

@Composable
fun showPreviewButtons() {
    //to remember the updated value even on scrreen oreintation
    var count = rememberSaveable { mutableIntStateOf(0) }
    notificationUi(count.intValue, { count.intValue++ })
    messageCounter(count.value)
}

@Composable
fun notificationUi(count: Int, increment: () -> Unit) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Text(text = "you have increaSE COUNTER with ${count}")
        Button(
            onClick = {
                increment()

                Log.e(TAG, "notificationUi: Button Clicked")
            }
        ) {
            Text(text = "update counter")

        }
        messageCounter(count)

    }


}


@Composable
fun messageCounter(value: Int) {
    Card(

    ) {
        Row {

            Image(imageVector = Icons.Outlined.Call, contentDescription = "")
            Text(text = "Message sent so far - $value")
        }


    }
}