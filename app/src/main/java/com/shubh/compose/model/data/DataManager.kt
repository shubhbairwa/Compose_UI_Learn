package com.shubh.compose.model.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataManager {

    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read()
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)


    }

    fun loadJSONFromAsset(context: Context, fileName: String) = try {

        context.assets.open(fileName).bufferedReader().use {
            it.readText()
            val gson = Gson()
            val quoteList: List<Quote>? = it.readText().let {
                gson.fromJson(it, object : TypeToken<List<Quote>>() {}.type)
            }
            data = quoteList!!.toTypedArray()
            isDataLoaded.value = true
        }
    } catch (e: Exception) {
        e.printStackTrace()

    }


}