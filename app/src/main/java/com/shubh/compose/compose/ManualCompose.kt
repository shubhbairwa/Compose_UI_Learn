package com.shubh.compose.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubh.compose.R

/**
 * this is the recyclerview compose
 */

@Preview
@Composable
fun previewList() {
    LazyColumn(content = {
        items(getRandomItems()) { data ->
            cardContactPersonForList(
                RandomItem(
                    imageId = data.imageId,
                    title = data.title,
                    content = data.content
                )
            )
        }
    })
}


/**
 * this is the recyclerview-item compose
 */
@Composable
fun cardContactPersonForList(randomItem: RandomItem) {

    //todo it will provide us the context in the compose
    var context= LocalContext.current

    Card(modifier = Modifier
        .padding(4.dp)
        .clickable {
            Toast.makeText(context, randomItem.title, Toast.LENGTH_SHORT).show()
        }) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(randomItem.imageId),
                contentDescription = "image for contact icon",
                Modifier.weight(.1f)

            )
            ItemDescription(
                randomItem.title,
                randomItem.content,
                Modifier
                    .padding(4.dp, 0.dp)
                    .weight(.9f)
            )
        }
    }
}



/**
 * this is the reusable compose compose
 */
@Composable
fun ItemDescription(title: String, content: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontFamily = FontFamily.Cursive,
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = content)
    }
}


/**
 * this is the data class for recyclerview item
 */
data class RandomItem(
    val title: String,
    val content: String,
    val imageId: Int // Assuming it's a drawable resource ID
)



fun getRandomItems(): MutableList<RandomItem> {
    return mutableListOf(
        RandomItem("Apple", "A delicious fruit", R.drawable.ic_building),
        RandomItem("Banana", "Rich in vitamins", R.drawable.hospital_fill),
        RandomItem("Cherry", "Sweet and juicy", R.drawable.ic_building),
        RandomItem("Dragon Fruit", "A tropical delight", R.drawable.hospital_fill),
        RandomItem("Elderberry", "Full of antioxidants", R.drawable.ic_building),
        RandomItem("Fig", "A healthy snack", R.drawable.hospital_fill),
        RandomItem("Grape", "Perfect for smoothies", R.drawable.ic_building),
        RandomItem("Honeydew", "Refreshing and light", R.drawable.hospital_fill),
        RandomItem("Ice Plant", "A unique taste", R.drawable.ic_building),
        RandomItem("Jackfruit", "Exotic and nutritious", R.drawable.hospital_fill),
        RandomItem("Apple", "A delicious fruit", R.drawable.ic_building),
        RandomItem("Banana", "Rich in vitamins", R.drawable.hospital_fill),
        RandomItem("Cherry", "Sweet and juicy", R.drawable.ic_building),
        RandomItem("Dragon Fruit", "A tropical delight", R.drawable.hospital_fill),
        RandomItem("Elderberry", "Full of antioxidants", R.drawable.ic_building),
        RandomItem("Fig", "A healthy snack", R.drawable.hospital_fill),
        RandomItem("Grape", "Perfect for smoothies", R.drawable.ic_building),
        RandomItem("Honeydew", "Refreshing and light", R.drawable.hospital_fill),
        RandomItem("Ice Plant", "A unique taste", R.drawable.ic_building),
        RandomItem("Jackfruit", "Exotic and nutritious", R.drawable.hospital_fill)


    )
}



/**
 * this is the new recyclerview-item with Space compose who gonna act like margin of xml
 */
@Composable
fun RandomItemCard(item: RandomItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle Click */ }
            .padding(8.dp),

        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = item.title,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            //act like margin
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = item.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = item.content, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}


/**
 * this is the Textview compose
 */

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!", fontSize = 36.sp, color = Color.Blue, textAlign = TextAlign.Center

    )
}


/**
 * this is the Button compose with fusion of two more predefined
 * compose like text and image
 *
 */
@Composable
fun buttonCompose() {
    Button(onClick = {

    }) {
        Text(text = "Shubh")
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "dummy",
            Modifier.size(20.dp, 10.dp),


            )

    }
}


/**
 * this is the EditText compose
 */
@Composable
fun textFieldCompose() {
    var state = remember { mutableStateOf("") }

    TextField(value = state.value, onValueChange = {
        state.value = it
    }, label = {
        Text(text = "Enter Message")

    })
}

//@Preview(showBackground = true)
@Composable
 fun previewFunction() {

    Text(
        text = "Enter Message", modifier = Modifier
            .background(Color.Gray)
            .border(6.dp, Color.Red)
            .padding(20.dp)
    )


}

@Preview(showBackground = true)
@Composable
 fun previewFunctionButton() {

    buttonCompose()

}

@Preview(showBackground = true)
@Composable
 fun previewFunctiontextFiled() {
    textFieldCompose()


}