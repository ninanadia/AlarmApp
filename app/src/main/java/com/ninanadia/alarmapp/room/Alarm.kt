package com.ninanadia.alarmapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alarm(
    /*
    @primaryKey digunakan untuk menjadikan sebuah column
    menjadi primary, autogenerate digunakan untuk membuat
    id secara otomatis
    */
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val time: String,
    val date: String,
    val note: String,
    val type: Int
)