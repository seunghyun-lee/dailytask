package com.devbuildrun.dailytask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todoitem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var title: String
) {
}