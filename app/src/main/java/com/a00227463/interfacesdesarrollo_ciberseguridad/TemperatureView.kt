package com.a00227463.interfacesdesarrollo_ciberseguridad

import android.annotation.SuppressLint
import com.a00227463.interfacesdesarrollo_ciberseguridad.controller.TemperatureConverter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TemperatureView(navController:NavHostController, modifier: Modifier = Modifier) {
    var temperatureInput by remember { mutableStateOf(TextFieldValue("")) }
    var selectedConversion by remember { mutableStateOf("Celsius to Fahrenheit") }
    var convertedValue by remember { mutableStateOf("") }

    val conversionOptions = listOf("Celsius to Fahrenheit", "Fahrenheit to Celsius")


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Temperature Converter", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = temperatureInput,
            onValueChange = { temperatureInput = it },
            label = { Text("Enter temperature") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        DropdownMenu(
            options = conversionOptions,
            selectedOption = selectedConversion,
            onOptionSelected = { selectedConversion = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val inputValue = temperatureInput.text.toFloatOrNull()
                convertedValue = if (inputValue != null) {
                    when (selectedConversion) {
                        "Celsius to Fahrenheit" -> TemperatureConverter.celsiusToFahrenheit(
                            inputValue
                        ).toString()

                        "Fahrenheit to Celsius" -> TemperatureConverter.fahrenheitToCelsius(
                            inputValue
                        ).toString()

                        else -> ""
                    }
                } else {
                    "Invalid input"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convert")
        }



        Spacer(modifier = Modifier.height(16.dp))

        if (convertedValue.isNotEmpty()) {
            Text(
                text = "Converted Value: $convertedValue",
                style = MaterialTheme.typography.bodyLarge
            )
        }

            Button(
                onClick = {
                    navController.popBackStack();
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Return to Home Screen")
            }
    }
}

@Composable
fun DropdownMenu(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = selectedOption)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
