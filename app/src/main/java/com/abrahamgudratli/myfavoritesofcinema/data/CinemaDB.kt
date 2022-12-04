package com.abrahamgudratli.myfavoritesofcinema.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [ThingsToDo::class, PlacesToGo::class], version = 2)
abstract class CinemaDB : RoomDatabase() {
    abstract fun getThingsToDoDao() : ThingsToDoDao
    abstract fun getPlacesToGODao() : PlacesToGoDao

    companion object {
        @Volatile
        var INSTANCE: CinemaDB? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): CinemaDB {
            val tempDB = INSTANCE
            if (tempDB != null) {
                return tempDB
            }
            synchronized(Any()) {
                var instance = Room.databaseBuilder(context.applicationContext,
                CinemaDB::class.java,
                "CinemaDB").build()
                INSTANCE = instance
                return instance
            }
        }


    }







}