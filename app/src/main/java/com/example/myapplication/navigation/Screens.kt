package com.example.myapplication.navigation

import androidx.navigation.NavHostController
import com.example.myapplication.util.Action
import com.example.myapplication.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list : (Action) -> Unit = {
        navController.navigate("list/${it.name}"){
            popUpTo(LIST_SCREEN){inclusive = true}
        }
    }

    val task : (Int) -> Unit = { id ->
        navController.navigate("task/${id}")
    }
}