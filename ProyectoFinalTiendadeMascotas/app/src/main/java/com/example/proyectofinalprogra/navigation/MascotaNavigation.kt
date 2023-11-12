package com.example.proyectofinalprogra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinalprogra.screens.MascotaSplashScreen
import com.example.proyectofinalprogra.screens.home.Home

//Aquí se me permite navegar desde la ventanaSplash hacia la ventana de inicio.
@Composable
fun MascotaNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MascotaScreens.SplashScreen.name)
    {
     composable(MascotaScreens.SplashScreen.name){
         MascotaSplashScreen(navController = navController)
     }
        composable(MascotaScreens.MascotaHomeScreen.name){
            Home(navController = navController)
        }
    }
}