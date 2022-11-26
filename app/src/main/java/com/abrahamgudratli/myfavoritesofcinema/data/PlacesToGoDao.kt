package com.abrahamgudratli.myfavoritesofcinema.data

import androidx.room.*

@Dao
interface PlacesToGoDao {

    @Query("SELECT * FROM PlacesToGo")
    suspend fun getAllPlaces()

    @Insert
    suspend fun addNewPlace()

    @Update
    suspend fun updatePlaceDetail()

    @Delete
    suspend fun deletePlace()

}