package com.abrahamgudratli.myfavoritesofcinema.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlacesToGoDao {

    @Query("SELECT * FROM PlacesToGo")
    fun getAllPlaces() : LiveData<List<PlacesToGo>>

    @Insert
    suspend fun addNewPlace(item: PlacesToGo)

    @Update
    suspend fun updatePlaceDetail(item: PlacesToGo)

    @Delete
    suspend fun deletePlace(item: PlacesToGo)

}