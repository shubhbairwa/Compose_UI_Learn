package com.shubh.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shubh.compose.compose.RandomItemCard
import com.shubh.compose.compose.cardContactPersonForList
import com.shubh.compose.compose.getRandomItems
import com.shubh.compose.compose.notificationUi
import com.shubh.compose.compose.previewList
import com.shubh.compose.compose.showPreviewButtons
import com.shubh.compose.model.data.DataManager
import com.shubh.compose.model.data.DataManager.loadJSONFromAsset
import com.shubh.compose.model.data.Quote
import com.shubh.compose.quotes.screens.QuoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val json = loadJSONFromAsset(this, "quotes.json")

        setContent {
            App()
            //  showPreviewButtons()
            //  previewList()
//            Column(verticalArrangement = Arrangement.SpaceBetween) {
//                previewFunction()
//                previewFunctionButton()
//                previewFunctiontextFiled()
//            }

        }
    }


    @Preview
    @Composable
    fun App() {
        val quotes = listOf(
            Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
            Quote(
                "Success is not final, failure is not fatal: it is the courage to continue that counts.",
                "Winston Churchill"
            ),
            Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"),
            Quote("It always seems impossible until it’s done.", "Nelson Mandela"),
            Quote("Do what you can, with what you have, where you are.", "Theodore Roosevelt"),
            Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
            Quote(
                "Success is not final, failure is not fatal: it is the courage to continue that counts.",
                "Winston Churchill"
            ),
            Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"),
            Quote("It always seems impossible until it’s done.", "Nelson Mandela"),
            Quote("Do what you can, with what you have, where you are.", "Theodore Roosevelt")
        ).toTypedArray()
        QuoteListScreen(data = quotes) {
            Toast.makeText(this, "clicked on an item", Toast.LENGTH_SHORT).show()
        }
//        if (DataManager.isDataLoaded.value) {
//
//        }
    }
}






