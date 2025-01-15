package com.example.myapplication.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.models.ToDoTask
import com.example.myapplication.data.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val mToDoRepository: ToDoRepository
): ViewModel(){
    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks = _allTasks.asStateFlow()

    fun getAllTasks(){
        viewModelScope.launch {
            mToDoRepository.getAllTasks.collect{
                _allTasks.value = it
            }
        }
    }
}