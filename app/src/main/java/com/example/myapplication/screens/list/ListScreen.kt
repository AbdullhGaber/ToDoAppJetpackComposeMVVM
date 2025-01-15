package com.example.myapplication.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.myapplication.screens.list.components.ListAppBar

@Composable
fun ListScreen(navigateToTaskScreen : (Int) -> Unit){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navigateToTaskScreen(-1)}
            ){
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Fab button"
                )
            }
        }
    ){ innerPadding ->
        innerPadding
        ListAppBar()
    }
}