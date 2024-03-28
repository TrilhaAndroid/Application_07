package br.com.leonardobarral.application_07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.leonardobarral.application_07.ui.theme.Application_07Theme
import androidx.navigation.compose.rememberNavController
import br.com.leonardobarral.application_07.models.LoginViewModel
import br.com.leonardobarral.application_07.screens.HomeView
import br.com.leonardobarral.application_07.screens.LoginView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application_07Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "index"
                    ){
                        composable(route = "index") {
                            HomeView(navController)
                        }

                        composable(route = "login") {
                            LoginView(LoginViewModel())
                        }
                    }

                }
            }
        }
    }
}