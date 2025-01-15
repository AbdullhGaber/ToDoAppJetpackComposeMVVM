package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.models.ToDoTask
import com.example.myapplication.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM ${Constants.TASK_TABLE} ORDER BY id ASC")
    fun getAllTasks() : Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.TASK_TABLE} WHERE id = :taskId ")
    fun getTaskById(taskId: Int) : Flow<ToDoTask>

    @Insert
    suspend fun addTask(task : ToDoTask)

    @Update
    suspend fun updateTask(task : ToDoTask)

    @Delete
    suspend fun deleteTask(task : ToDoTask)

    @Query("DELETE FROM ${Constants.TASK_TABLE}")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM ${Constants.TASK_TABLE} WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTasks(searchQuery : String) : Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.TASK_TABLE} ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortTasksByLowPriorities() : Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.TASK_TABLE} ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortTasksByHighPriorities() : Flow<List<ToDoTask>>
}