package com.example.mainactivity.models

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.R

class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val evename: TextView = view.findViewById(R.id.evename)
    val editButton: ImageView = view.findViewById(R.id.editButton)
    val deleteButton:ImageView = view.findViewById(R.id.deleteButton)
    val evetype:TextView = view.findViewById(R.id.evetype)
    val evevenue:TextView = view.findViewById(R.id.evevenue)
    val evedate:TextView = view.findViewById(R.id.evedate)
    val eveguests:TextView = view.findViewById(R.id.eveguests)
    val evefood:TextView = view.findViewById(R.id.evefood)
}