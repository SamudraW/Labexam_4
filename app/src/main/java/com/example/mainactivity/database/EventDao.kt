package com.example.mainactivity.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDao {

    @Insert
    suspend fun insert(event:Event)

    @Delete
    suspend fun delete(event:Event)

    @Query("SELECT * FROM Event")
    fun getAllEvents():List<Event>
}