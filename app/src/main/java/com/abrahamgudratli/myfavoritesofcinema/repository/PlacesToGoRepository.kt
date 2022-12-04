package com.abrahamgudratli.myfavoritesofcinema.repository

import androidx.lifecycle.LiveData
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGo
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGoDao
import com.abrahamgudratli.myfavoritesofcinema.data.ThingsToDo

class PlacesToGoRepository(var dao: PlacesToGoDao) {

    suspend fun addNewThing(item: PlacesToGo) = dao.addNewPlace(item)
    suspend fun updateThingDetails(item: PlacesToGo) = dao.updatePlaceDetail(item)
    suspend fun deleteThing(item: PlacesToGo) = dao.deletePlace(item)
    val allPlaces: LiveData<List<PlacesToGo>> = dao.getAllPlaces()

}