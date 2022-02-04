package com.ninanadia.alarmapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface AlarmDao {

    //Query untuk menambahkan data alarm
    @Insert
    fun addAlarm (alarm: Alarm)

    //Query untuk mengambil data alarm
    @Query("SELECT * FROM alarm")
    // LiveData untuk memberitahu perubahan data yang terjadi di activity secara langsung
    // sehingga recyclerview dapat memperbarui data secara langsung
    fun getAlarm(): LiveData<List<Alarm>>

    //Query untuk menghapus data alarm
    @Delete
    fun deleteAlarm(alarm: Alarm)
}