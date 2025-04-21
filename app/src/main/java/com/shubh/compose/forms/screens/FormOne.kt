package com.shubh.compose.forms.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubh.compose.R
import com.shubh.compose.compose.TextFieldCompose


@Composable
fun FormOne(context: Context) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(0.dp, 16.dp)) {
            CustomTextComposeForApp(
                modifier = Modifier.fillMaxWidth(),
                text = "Form One",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(8.dp))
            CustomTextComposeForApp(
                modifier = Modifier.fillMaxWidth(),
                text = "Basic Form For Basic App",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            val nametextFieldState = remember { mutableStateOf("") }
            val companyTextFieldState = remember { mutableStateOf("") }
            NewTypeTextField(
                Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp), nametextFieldState, "Person Name"
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NewTypeTextField(
                Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp), companyTextFieldState, "Company Name"
            )
            Spacer(modifier = Modifier.padding(8.dp))
            ChooseSex(
                modifier = Modifier
                    .padding(8.dp)
            )

            Button(
                onClick = {
                    giveMeData(
                        UserDetails(
                            name = nametextFieldState.value,
                            companyName = companyTextFieldState.value,
                            sex = selectedRadioUtton
                        ),
                        context
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(56.dp)
            ) {
                Text(text = "Submit")


            }

        }
    }

}

data class UserDetails(var name: String, var companyName: String, var sex: String)


fun giveMeData(userDetails: UserDetails, context: Context) {
    Toast.makeText(context, userDetails.toString(), Toast.LENGTH_SHORT).show()

}

/*fun getDataFromForm(): () -> Unit {
return
}*/

@Composable
fun ChooseSex(modifier: Modifier = Modifier) {
    Row {
        CustomTextComposeForApp(
            modifier = modifier,
            text = "Sex: ",
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.padding(8.dp))
        RadioButtonSingleSelection()


    }
}

var selectedRadioUtton: String = ""

@Preview
@Composable
fun RadioButtonSingleSelection() {
    val radioOptions = listOf("Male", "Female")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Row(
        modifier = Modifier
            .padding(8.dp)
            .selectableGroup()
    ) {
        radioOptions.forEach { text ->
            Row(
                Modifier

                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null // null recommended for accessibility with screen readers
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )

            }
        }
        selectedRadioUtton = selectedOption
    }
}

@Composable
fun CustomTextComposeForApp(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    textAlign: TextAlign
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        style = style

    )
}

@Composable
fun NewTypeTextField(
    modifier: Modifier = Modifier,
    nametextFieldState: MutableState<String>,
    label: String
) {
    OutlinedTextField(
        value = nametextFieldState.value, onValueChange = {
            nametextFieldState.value = it
        }, singleLine = true, label = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier

                    .fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(R.drawable.ic_building),
                    contentDescription = "name"
                )
                Spacer(modifier = Modifier.padding(2.dp, 0.dp, 0.dp, 0.dp))
                Text(
                    text = label,
                    modifier = Modifier.fillMaxWidth(),
                )
            }

        }, modifier = modifier
    )
}