package com.example.mainactivity.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventData: ViewModel() {

    private val _data = MutableLiveData<List<Event>>()

    val data: LiveData<List<Event>> = _data

    fun setData(data: List<Event>){
        _data.value = data
        }

}