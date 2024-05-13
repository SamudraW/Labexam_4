package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.mainactivity.database.Event
import com.example.mainactivity.database.EventData
import com.example.mainactivity.database.EventDatabase
import com.example.mainactivity.database.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventActivity : AppCompatActivity() {

    private lateinit var viewModel: EventData // Assuming this is your ViewModel class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        viewModel = ViewModelProvider(this).get(EventData::class.java) // Initialize your ViewModel

        val repository = EventRepository(EventDatabase.getInstance(this))

        // Assuming you have references to the EditText fields in your UI
        val enameEditText: EditText = findViewById(R.id.ename)
        val etypeEditText: EditText = findViewById(R.id.etype)
        val evenueEditText: EditText = findViewById(R.id.evenue)
        val edateEditText: EditText = findViewById(R.id.edate)
        val eguestsEditText: EditText = findViewById(R.id.eguests)
        val efoodEditText: EditText = findViewById(R.id.efood)

        // Set click listener for "Done" ImageView or any other appropriate button
        val doneImageView: ImageView = findViewById(R.id.imageView)
        doneImageView.setOnClickListener {
            addEventToDatabase(
                enameEditText,
                etypeEditText,
                evenueEditText,
                edateEditText,
                eguestsEditText,
                efoodEditText,
                repository
            )
        }
    }

    private fun addEventToDatabase(
        enameEditText: EditText,
        etypeEditText: EditText,
        evenueEditText: EditText,
        edateEditText: EditText,
        eguestsEditText: EditText,
        efoodEditText: EditText,
        repository: EventRepository
    ) {
        // Retrieve text from EditText fields
        val ename = enameEditText.text.toString()
        val etype = etypeEditText.text.toString()
        val evenue = evenueEditText.text.toString()
        val edate = edateEditText.text.toString()
        val eguests = eguestsEditText.text.toString()
        val efood = efoodEditText.text.toString()

        // Create an Event object
        val event = Event(ename, etype, evenue, edate, eguests, efood)

        // Insert event into the database
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(event)
            // Update UI after insertion
            val data = repository.getAllEvents()
            withContext(Dispatchers.Main) {
                //have a viewModel to update UI
                viewModel.setData(data)

                val intent = Intent(this@EventActivity, EventHomeActivity::class.java)
                startActivity(intent)

            }
        }
    }
}