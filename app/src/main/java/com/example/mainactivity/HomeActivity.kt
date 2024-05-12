package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    private lateinit var schbtn:Button
    private lateinit var chkbtn:Button
    private lateinit var guebtn:Button
    private lateinit var evebtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        evebtn = findViewById<Button>(R.id.eventbtn)
        chkbtn = findViewById<Button>(R.id.checklistbtn)
        guebtn = findViewById<Button>(R.id.guestbtn)
        schbtn = findViewById<Button>(R.id.schedulebtn)

        evebtn.setOnClickListener {
            val intent = Intent(this, EventHomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}