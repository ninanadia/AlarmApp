package com.ninanadia.alarmapp.adapter

import android.content.Context
import android.gesture.GestureLibraries
import android.graphics.drawable.AdaptiveIconDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ninanadia.alarmapp.R
import com.ninanadia.alarmapp.room.Alarm
import kotlinx.android.synthetic.main.item_row_reminder_alarm.view.*

//class ini berfungsi untuk menghubungkan data dengan ui (list)
class AlarmAdapter() : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    var alarms = emptyList<Alarm>()

    class AlarmViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Alarm>){
        val alarmDiffUtil = AlarmDiffUtil(alarms, list)
        val alarmDiffUtilResult = DiffUtil.calculateDiff(alarmDiffUtil)
        this.alarms = list
        alarmDiffUtilResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        return AlarmViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row_reminder_alarm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val alarm = alarms[position]
        holder.view.item_time_alarm.text = alarm.time
        holder.view.item_date_alarm.text = alarm.date
        holder.view.item_note_alarm.text = alarm.note

        when (alarm.type) {
            0 -> holder.view.item_img_one_time.loadImageDrawable(
                holder.view.context,
                R.drawable.ic_one_time
            )
            1 -> holder.view.item_img_one_time.loadImageDrawable(
                holder.view.context,
                R.drawable.ic_repeating
            )
        }
    }
    override fun getItemCount() = alarms.size

    private fun ImageView.loadImageDrawable(context: Context, drawable: Int){
        Glide.with(context).load(drawable).into(this)
    }

}
