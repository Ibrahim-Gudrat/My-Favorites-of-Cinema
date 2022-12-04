package com.abrahamgudratli.myfavoritesofcinema.repository

import androidx.lifecycle.LiveData
import com.abrahamgudratli.myfavoritesofcinema.data.ThingsToDo
import com.abrahamgudratli.myfavoritesofcinema.data.ThingsToDoDao

class ThingsToDoRepository(var dao: ThingsToDoDao) {

    suspend fun addNewThing(item: ThingsToDo) = dao.addNewThing(item)
    suspend fun updateThingDetails(item: ThingsToDo) = dao.updateThingDetail(item)
    suspend fun deleteThing(item: ThingsToDo) = dao.deleteThing(item)
    var allThings: LiveData<List<ThingsToDo>> = dao.getAllThings()

}