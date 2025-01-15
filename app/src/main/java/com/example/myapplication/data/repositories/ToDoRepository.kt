package com.example.myapplication.data.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.TaskDao
import com.example.myapplication.data.models.ToDoTask
import com.example.myapplication.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val mTaskDao : TaskDao
) {
    val getAllTasks : Flow<List<ToDoTask>> = mTaskDao.getAllTasks()
    val sortByLowPriorities : Flow<List<ToDoTask>> = mTaskDao.sortTasksByLowPriorities()
    val sortByHighPriorities : Flow<List<ToDoTask>> = mTaskDao.sortTasksByHighPriorities()

    fun getTaskById(taskId : Int) : Flow<ToDoTask>{
        return mTaskDao.getTaskById(taskId)
    }
    suspend fun addTask(task : ToDoTask){
        mTaskDao.addTask(task)
    }

    suspend fun updateTask(task : ToDoTask){
        mTaskDao.updateTask(task)
    }

    suspend fun deleteTask(task : ToDoTask){
        mTaskDao.deleteTask(task)
    }

    suspend fun deleteAllTasks(){
        mTaskDao.deleteAllTasks()
    }

    fun searchTasks(searchQuery : String) : Flow<List<ToDoTask>>{
        return mTaskDao.searchTasks(searchQuery)
    }

    fun sortTasksByLowPriorities() : Flow<List<ToDoTask>>{
        return mTaskDao.sortTasksByLowPriorities()
    }


    fun sortTasksByHighPriorities() : Flow<List<ToDoTask>>{
        return mTaskDao.sortTasksByHighPriorities()
    }
}