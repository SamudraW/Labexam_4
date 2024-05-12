package com.example.mainactivity.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Event::class], version = 1)
abstract class EventDatabase: RoomDatabase() {
    abstract fun getEventDao():EventDao

    companion object{
        @Volatile
        private var INSTANCE:EventDatabase?= null

        fun getInstance(context: Context):EventDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context,
                    EventDatabase::class.java,
                    "event_db"
                ).build().also {
                    INSTANCE = it
                }
            }
            }
        }

}