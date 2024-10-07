package com.a00227463.interfacesdesarrollo_ciberseguridad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.a00227463.interfacesdesarrollo_ciberseguridad.ui.LoginScreen
import com.a00227463.interfacesdesarrollo_ciberseguridad.ui.MainMenuScreen
import com.a00227463.interfacesdesarrollo_ciberseguridad.ui.theme.InterfacesDesarrollo_CiberseguridadTheme
import com.a00227463.interfacesdesarrollo_ciberseguridad.TemperatureView
import com.a00227463.interfacesdesarrollo_ciberseguridad.RockPaperScissorsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfacesDesarrollo_CiberseguridadTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    val navController = rememberNavController()
    var isLoggedIn by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Desarrollo de Interfaces")
                }
            )
        }
    ) { innerPadding ->
        NavigationHost(
            navController = navController,
            isLoggedIn = isLoggedIn,
            onLoginChange = { isLoggedIn = it },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun NavigationHost(
    navController: androidx.navigation.NavHostController,
    isLoggedIn: Boolean,
    onLoginChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "mainMenu" else "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                onLoginChange(true)
                navController.navigate("mainMenu") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("mainMenu") {
            MainMenuScreen(
                onLogout = {
                    onLoginChange(false)
                    navController.navigate("login") {
                        popUpTo("mainMenu") { inclusive = true }
                    }
                },
                onNavigateToTemperature = {
                    navController.navigate("temperatureView")
                },
                onNavigateToRockPaperScissors = {
                    navController.navigate("rockPaperScissors")
                })

        }
        composable("temperatureView") {
            TemperatureView(navController = navController)
        }
        composable("rockPaperScissors") {
            RockPaperScissorsView(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    InterfacesDesarrollo_CiberseguridadTheme {
        MainApp()
    }
}