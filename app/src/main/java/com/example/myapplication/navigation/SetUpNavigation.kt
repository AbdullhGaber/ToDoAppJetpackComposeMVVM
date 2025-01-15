package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.myapplication.navigation.destination.listComposable
import com.example.myapplication.navigation.destination.taskComposable
import com.example.myapplication.util.Constants.LIST_SCREEN

@Composable
fun SetUpNavigation(
    navHostController: NavHostController
){
    val screens = remember(key1 = navHostController) {
        Screens(navHostController)
    }
    NavHost(navController = navHostController , startDestination = "list/-1"){
        listComposable(
            screens.task
        )
        taskComposable(
            screens.list
        )
    }
}