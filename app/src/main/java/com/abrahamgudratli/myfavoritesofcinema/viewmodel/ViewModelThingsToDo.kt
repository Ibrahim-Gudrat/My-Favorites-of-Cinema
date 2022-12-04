package com.abrahamgudratli.myfavoritesofcinema.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abrahamgudratli.myfavoritesofcinema.data.CinemaDB
import com.abrahamgudratli.myfavoritesofcinema.data.ThingsToDo
import com.abrahamgudratli.myfavoritesofcinema.repository.ThingsToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch

class ViewModelThingsToDo(application: Application): AndroidViewModel(application) {

    private var listOfThings: LiveData<List<ThingsToDo>>
    private var repository: ThingsToDoRepository

    init {
        val dao = CinemaDB.getDatabase(application).getThingsToDoDao()
        repository = ThingsToDoRepository(dao)
        listOfThings = repository.allThings
    }

    fun add(item: ThingsToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewThing(item)
        }
    }

    fun update(item: ThingsToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateThingDetails(item)
        }
    }

    fun delete(item: ThingsToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteThing(item)
        }
    }


}