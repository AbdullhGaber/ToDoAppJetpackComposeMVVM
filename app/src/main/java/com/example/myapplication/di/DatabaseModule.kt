package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.TaskDao
import com.example.myapplication.data.ToDoRoomDB
import com.example.myapplication.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideToDoRoomDB(
        @ApplicationContext context : Context
    ) = Room.databaseBuilder(
            context = context,
            klass = ToDoRoomDB::class.java,
            name = Constants.DATABASE_NAME
    ).build()


    @Provides
    @Singleton
    fun provideTaskDao(
        roomDB: ToDoRoomDB
    ) : TaskDao{
        return roomDB.taskDao
    }
}