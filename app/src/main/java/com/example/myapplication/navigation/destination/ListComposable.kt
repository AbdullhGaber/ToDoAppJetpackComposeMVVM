package com.example.myapplication.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.screens.list.ListScreen
import com.example.myapplication.util.Constants.LIST_ARGUMENT_KEY
import com.example.myapplication.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen : (Int) -> Unit
){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(name = LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){
        ListScreen({})
    }
}