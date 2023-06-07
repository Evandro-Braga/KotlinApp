package com.example.myapplication1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.models.Driver

class DriverViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val TvPosition = itemView.findViewById<TextView>(R.id.TvPosition)
    private val TvName = itemView.findViewById<TextView>(R.id.TvName)
    private val TvPoints = itemView.findViewById<TextView>(R.id.TvPoints)

    fun bind (item: Driver) {
        TvPosition.text = item.position
        TvName.text = item.name
        TvPoints.text = item.points
    }
}