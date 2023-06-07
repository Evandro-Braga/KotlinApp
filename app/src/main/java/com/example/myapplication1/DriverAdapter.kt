package com.example.myapplication1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.models.Driver

class DriverAdapter(): RecyclerView.Adapter<DriverViewHolder>() {

    private var items = listOf<Driver>()

    fun updateItems(newItems: List<Driver>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_driver, parent, false)
        return DriverViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        holder.bind(items[position])
    }
}