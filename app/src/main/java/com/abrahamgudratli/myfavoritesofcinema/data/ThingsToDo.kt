package com.abrahamgudratli.myfavoritesofcinema.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ThingsToDo")
data class ThingsToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String,
    var image: Int,
    var rating: Int
)