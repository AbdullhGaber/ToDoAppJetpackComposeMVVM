package com.example.myapplication.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.util.Action
import com.example.myapplication.util.Constants.LIST_ARGUMENT_KEY
import com.example.myapplication.util.Constants.LIST_SCREEN
import com.example.myapplication.util.Constants.TASK_ARGUMENT_KEY
import com.example.myapplication.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen : (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(name = TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){
        
    }
}