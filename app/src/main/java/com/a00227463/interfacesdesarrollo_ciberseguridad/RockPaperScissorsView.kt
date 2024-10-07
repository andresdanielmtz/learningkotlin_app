package com.a00227463.interfacesdesarrollo_ciberseguridad
import com.a00227463.interfacesdesarrollo_ciberseguridad.controller.RockPaperScissors
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.*

@Composable
fun RockPaperScissorsView(navController: NavHostController, modifier: Modifier = Modifier) {
    var playerChoice by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Rock Paper Scissors", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            navController.popBackStack()
        })
        {
            Text("Return to Home Screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Your choice: $playerChoice")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { playerChoice = "rock" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Rock")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { playerChoice = "scissors" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Scissors")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { playerChoice = "Paper" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Paper")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {

                result = RockPaperScissors.play(playerChoice)
            },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("Play")
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (result.isNotEmpty()) {
            Text(text = result)
        }



    }
}