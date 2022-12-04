package com.abrahamgudratli.myfavoritesofcinema.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlacesToGo")
data class PlacesToGo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String,
    var image: String,
    var rating: String
)