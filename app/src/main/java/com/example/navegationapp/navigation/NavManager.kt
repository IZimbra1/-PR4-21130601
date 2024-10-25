package com.example.navegationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegationapp.viewModels.LoteriaViewModel
import com.example.navegationapp.views.Descuentos
import com.example.navegationapp.views.DogYear
import com.example.navegationapp.views.Menu
import com.example.navegationapp.views.Loteria

@Composable
fun NavManager(viewModels: LoteriaViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            Menu(navController)
        }
        composable("DogYear"){
            DogYear(navController)
        }
        composable("Loteria"){
            Loteria(navController,  viewModels = viewModels)
        }
        composable("Descuentos"){
            Descuentos(navController)
        }
    }
}