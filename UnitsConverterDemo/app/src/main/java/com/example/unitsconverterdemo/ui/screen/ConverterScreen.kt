package com.example.unitsconverterdemo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitsconverterdemo.R
import com.example.unitsconverterdemo.ui.theme.UnitsConverterDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen() {
    val km_miles = 0.621
    val km_yard = 1093.613
    val km_foot = 3280.84

    val context = LocalContext.current

    var inputText by rememberSaveable {
        mutableStateOf("")
    }

    var result by rememberSaveable {
        mutableStateOf("0")
    }

    var inputErrorState by rememberSaveable {
        mutableStateOf(false)
    }

    fun validate(text: String) {
        // inputErrorState = text.length==0
    }


    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = "Add meg az átváltani kívánt mértékegység értékét!") },
            value = inputText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // Nem tudnak Enter-rel új sort nyitni
            singleLine = true,
            onValueChange = {
                validate(inputText)
                // A notebook billentyűzetről tudtam betűt is begépelni!
                // Így ezt kivédem.
                try {
                    if (it.length>0) {
                        val testNumber = it.toInt()
                        inputText = it
                    }
                    else
                    {
                        inputText = it
                    }
                }catch (e: Exception){

                }
            },
            isError = inputErrorState)
        Row {
            Button(onClick = {
                if (inputText.length>0) {
                    var kmValue = inputText.toFloat()
                    result = (kmValue * km_miles).toString()
                }
                else
                {
                    // result = stringResource(R.string.need_give_value)
                     result = context.getString(R.string.need_give_value)
                }
            }) {
                Text(text = "km -> miles")
            }
            Button(onClick = {
                if (inputText.length>0) {
                    var inputValue = inputText.toFloat()
                    result = (inputValue * km_yard).toString()
                }
                else
                {
                    // result = stringResource(R.string.need_give_value)
                    result = context.getString(R.string.need_give_value)
                }
            }) {
                Text(text = "km -> yard")
            }
            Button(onClick = {
                if (inputText.length>0) {
                    var inputValue = inputText.toFloat()
                    result = (inputValue * km_foot).toString()
                }
                else
                {
                    // result = stringResource(R.string.need_give_value)
                    result = context.getString(R.string.need_give_value)
                }
            }) {
                Text(text = "km -> foot")
            }
        }
        Text(text = result, fontSize = 26.sp, color = Color.Blue)
    }
}

@Preview(showBackground = true)
@Composable
fun ConverterScreenPreview() {
    UnitsConverterDemoTheme {
        ConverterScreen()
    }
}