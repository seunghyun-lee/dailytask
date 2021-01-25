package com.devbuildrun.dailytask.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ Todoitem::class ], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoitamDao(): TodoitemDao
}