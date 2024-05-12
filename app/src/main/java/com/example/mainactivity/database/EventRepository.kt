package com.example.mainactivity.database

class EventRepository(
    private val db:EventDatabase
) {
    suspend fun insert(event: Event) = db.getEventDao().insert(event)
    suspend fun delete(event: Event) = db.getEventDao().delete(event)

    fun getAllEvents():List<Event> = db.getEventDao().getAllEvents()
}
