package com.example.myapplication.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.util.Constants

@Entity(tableName = Constants.TASK_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true) val id : Int = -1,
    val title : String,
    val description : String,
    val priority : Priority
)
