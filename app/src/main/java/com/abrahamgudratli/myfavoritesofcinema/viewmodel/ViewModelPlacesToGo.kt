package com.abrahamgudratli.myfavoritesofcinema.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abrahamgudratli.myfavoritesofcinema.data.CinemaDB
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGo
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGoDao
import com.abrahamgudratli.myfavoritesofcinema.repository.PlacesToGoRepository
import com.abrahamgudratli.myfavoritesofcinema.repository.ThingsToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelPlacesToGo(application: Application): AndroidViewModel(application) {

    var listOfPlaces: LiveData<List<PlacesToGo>>
    private var repository: PlacesToGoRepository

    init {
        val dao = CinemaDB.getDatabase(application).getPlacesToGODao()
        repository = PlacesToGoRepository(dao)
        listOfPlaces = repository.allPlaces
    }

    fun add(item: PlacesToGo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewThing(item)
        }
    }

    fun update(item: PlacesToGo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateThingDetails(item)
        }
    }

    fun delete(item: PlacesToGo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteThing(item)
        }
    }

}