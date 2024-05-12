package com.example.mainactivity.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event (
    var ename:String?,
    var etype:String?,
    var evenue:String?,
    var edate:String?,
    var eguests:String?,
    var efood:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
