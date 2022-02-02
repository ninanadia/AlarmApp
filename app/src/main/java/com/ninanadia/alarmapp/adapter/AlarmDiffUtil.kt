package com.ninanadia.alarmapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ninanadia.alarmapp.room.Alarm

//class ini berfungsi untuk menghitung perbedaan size
//atau ukuran data antara yang lama dan baru
//ketika terjadi perubahan
class AlarmDiffUtil(private val oldList: List<Alarm>, private val newList: List<Alarm>) : DiffUtil.Callback() {

    //Berfungsi untuk menghitung ukuran data lama
    override fun getOldListSize(): Int {
        return oldList.size
    }

    //Berfungsi untuk menghitung ukuran data baru setelah terjadi perubahan
    override fun getNewListSize(): Int {
        return newList.size
    }

    //Berfungsi untuk memeriksa kesamaan item
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    //Berfungsi untuk memeriksa data antara item lama dan baru
    //apakah sama atau tidak
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldData = oldList[oldItemPosition]
        val newData = newList[newItemPosition]
        return oldData.id == newData.id
                && oldData.date == newData.date
                && oldData.time == newData.time
                && oldData.note == newData.note
                && oldData.type == newData.type

    }
}