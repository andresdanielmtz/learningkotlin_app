package com.a00227463.interfacesdesarrollo_ciberseguridad.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainMenuScreen(
    onLogout: () -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToTemperature: () -> Unit,
    onNavigateToRockPaperScissors: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Andres Martinez A00227463")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNavigateToTemperature() }) {
            Text(text = "Convertidor de Temperatura")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onNavigateToRockPaperScissors() }) {
            Text(text = "Piedra, Papel o Tijeras")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Logout")
        }
    }
}
