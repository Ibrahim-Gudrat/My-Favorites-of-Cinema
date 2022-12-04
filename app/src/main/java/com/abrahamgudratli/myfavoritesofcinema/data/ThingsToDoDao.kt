package com.abrahamgudratli.myfavoritesofcinema.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ThingsToDoDao {

    @Query("SELECT * FROM ThingsToDo")
    fun getAllThings() : LiveData<List<ThingsToDo>>

    @Insert
    suspend fun addNewThing(item: ThingsToDo)

    @Update
    suspend fun updateThingDetail(item: ThingsToDo)

    @Delete
    suspend fun deleteThing(item: ThingsToDo)

}