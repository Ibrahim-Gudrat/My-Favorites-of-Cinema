package com.abrahamgudratli.myfavoritesofcinema.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface ThingsToDoDao {

    @Query("SELECT * FROM ThingsToDo")
    suspend fun getAllPlaces()

    @Insert
    suspend fun addNewPlace()

    @Update
    suspend fun updatePlaceDetail()

    @Delete
    suspend fun deletePlace()

}