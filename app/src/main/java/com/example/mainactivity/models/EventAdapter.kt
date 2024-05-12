package com.example.mainactivity.models

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.R
import com.example.mainactivity.database.Event
import com.example.mainactivity.database.EventData
import com.example.mainactivity.database.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventAdapter(events:List<Event>, repository: EventRepository, viewModel: EventData):
    RecyclerView.Adapter<EventViewHolder>() {

    var context: Context?= null
    val events = events
    val repository = repository
    val viewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_event,parent,false)

        context = parent.context

        return EventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.evename.text = events.get(position).ename
        holder.evetype.text = events.get(position).etype
        holder.evevenue.text = events.get(position).evenue
        holder.evedate.text = events.get(position).edate
        holder.eveguests.text = events.get(position).eguests
        holder.evefood.text = events.get(position).efood

        holder.deleteButton.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                repository.delete(events.get(position))
                val data = repository.getAllEvents()
                withContext(Dispatchers.Main){
                    viewModel.setData(data)
                }
            }
            Toast.makeText(context,"Hello", Toast.LENGTH_LONG).show()
            }
        }
}