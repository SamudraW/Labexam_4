package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.database.EventData
import com.example.mainactivity.database.EventDatabase
import com.example.mainactivity.database.EventRepository
import com.example.mainactivity.models.EventAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventHomeActivity : AppCompatActivity() {

    private lateinit var adapter: EventAdapter
    private lateinit var viewModel: EventData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_home)

        val recyclerView: RecyclerView = findViewById(R.id.eventRecyclerView)
        val repository = EventRepository(EventDatabase.getInstance(this))
        viewModel = ViewModelProvider(this)[EventData::class.java]
        viewModel.data.observe(this){
            adapter = EventAdapter(it,repository,viewModel)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllEvents()
            runOnUiThread {
                viewModel.setData(data)
            }
        }

        val addButton = findViewById<ImageView>(R.id.addButton)

        addButton.setOnClickListener {
            val intent = Intent(this,EventActivity::class.java)
            startActivity(intent)
            }
    }
}