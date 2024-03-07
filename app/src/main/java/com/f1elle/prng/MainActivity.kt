package com.f1elle.prng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.f1elle.prng.prng.ui.coprScreen
import com.f1elle.prng.prng.ui.prngScreen
import com.f1elle.prng.prng.ui.utils.Screen
import com.f1elle.prng.theme.Background
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.background(color = Background)) {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(Background)
                }
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.PRNGScreen.route
                ) {
                    composable(Screen.PRNGScreen.route) {
                        prngScreen(navController)
                    }
                    composable(Screen.CoprScreen.route) {
                        coprScreen(navController)
                    }
                }
            }
        }
    }
}

