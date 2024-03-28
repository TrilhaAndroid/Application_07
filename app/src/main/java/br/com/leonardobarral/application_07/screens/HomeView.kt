package br.com.leonardobarral.application_07.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeView(navController: NavHostController) {
    Column {
        Button(
            onClick = {
                navController.navigate("login")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x002B2D30)
            )
        ) {
            Text(
                text = "Login",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )

        }
    }
}