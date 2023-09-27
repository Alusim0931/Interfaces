package com.example.myapplication_compose

import NewPlayer
import Play
import Preferences
import mainMenu
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_compose.ui.theme.MyApplication_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication_composeTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    //contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(),
                    //horizontalAlignment = Alignment.CenterHorizontally,
                    //verticalArrangement = Arrangement.Center,
                    //color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "mainMenu"){
                        composable("NewPlayer"){ NewPlayer()
                        }
                        composable("Play"){ Play()
                        }
                        composable("Preferences"){ Preferences()
                        }
                        composable("About") { About()
                        }
                        composable("mainMenu") {mainMenu(navController)
                        }

                    }
                }
            }
        }
    }
}

