package com.devbuildrun.dailytask.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface TodoitemDao {
    @Query("SELECT * FROM Todoitem")
    fun getAll(): List<Todoitem>

    @Insert
    fun insert(todoitem: Todoitem)

    @Update
    fun update(todoitem: Todoitem)

    @Delete
    fun delete(todoitem: Todoitem)
}