package com.example.myapplication.screens.list.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.components.PriorityItem
import com.example.myapplication.data.models.Priority
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ListAppBar(){
//    DefaultListAppBar(
//        onSearchClicked={},
//        onSortClicked = {},
//        onDeleteClicked ={},
//    )
    SearchAppBar(
        text = "",
        onSearchClicked = {},
        onClosedClicked = {},
        onTextChange = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked : () -> Unit,
    onSortClicked : (Priority) -> Unit,
    onDeleteClicked : () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = "tasks",
                color = MaterialTheme.colorScheme.secondary
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            ListAppBarActions(
                onSearchClicked,
                onSortClicked,
                onDeleteClicked
            )
        }
    )
}

@Composable
fun SearchAppBar(
    text : String,
    onTextChange :  (String) -> Unit,
    onClosedClicked : () -> Unit,
    onSearchClicked: (String) -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.primary
    ) {
        TextField(
            value = text,
            onValueChange = {onTextChange(it)},
            singleLine = true,
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.secondary,
                )
            },
            trailingIcon = {
                IconButton(onClick = { onClosedClicked() }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colorScheme.secondary,
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun ListAppBarActions(
    onSearchClicked : () -> Unit,
    onSortClicked : (Priority) -> Unit,
    onDeleteClicked : () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked : () -> Unit
){
    IconButton(
        onClick = {onSearchClicked()}
    ){
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Icon",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun SortAction(
    onSortClicked : (Priority) -> Unit
){
    val expanded = remember { mutableStateOf(false) }

    IconButton(
        onClick = {expanded.value = true}
    ){
        Icon(
            painter = painterResource(R.drawable.filter_list_ic),
            contentDescription = "Sort Icon",
            tint = MaterialTheme.colorScheme.secondary
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = {expanded.value = false}
        ) {
            repeat(4){
                DropdownMenuItem(
                    onClick = {
                        expanded.value = false
                        when(it){
                            0 -> {
                               //Low
                                onSortClicked(Priority.LOW)
                            }
                            1 -> {
                                //Medium
                                onSortClicked(Priority.MEDIUM)
                            }
                            2 -> {
                                //High
                                onSortClicked(Priority.HIGH)
                            }
                            3 -> {
                                onSortClicked(Priority.NONE)
                            }

                        }
                    },
                    text = {
                        PriorityItem(Priority.entries[it])
                    }
                )
            }
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteClicked : () -> Unit
){
    val expanded = remember { mutableStateOf(false) }

    IconButton(
        onClick = {expanded.value = true}
    ){
        Icon(
            painter = painterResource(R.drawable.more_ic),
            contentDescription = "Delete Icon",
            tint = MaterialTheme.colorScheme.secondary
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = {expanded.value = false}
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded.value = false
                    onDeleteClicked()
                },
                text = {
                    Text(text = "Delete All")
                }
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewListAppBar(){
    MyApplicationTheme {
        ListAppBar()
    }
}