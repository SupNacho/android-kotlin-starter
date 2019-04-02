package com.example.krzdabrowski.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.krzdabrowski.myapplication.database.ObjectBox
import com.example.krzdabrowski.myapplication.model.Event
import com.example.krzdabrowski.myapplication.repository.EventRepository
import io.objectbox.Box
import io.objectbox.kotlin.boxFor

class EventViewModel(private val repository: EventRepository): ViewModel() {

    private lateinit var eventsList: LiveData<List<Event>>
    val box: Box<Event> = ObjectBox.boxStore.boxFor()

    fun getEventsFromRetrofit(): LiveData<List<Event>> {
        eventsList = repository.fetchPastEvents()
        return eventsList
    }

    fun saveToDatabase(data: List<Event>) {
        repository.saveToDatabase(box, data)
    }

}