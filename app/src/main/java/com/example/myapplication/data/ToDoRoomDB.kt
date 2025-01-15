package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.models.ToDoTask

@Database(entities = [ToDoTask::class] , version = 1 , exportSchema = false)
abstract class ToDoRoomDB : RoomDatabase(){
    abstract val taskDao : TaskDao
}