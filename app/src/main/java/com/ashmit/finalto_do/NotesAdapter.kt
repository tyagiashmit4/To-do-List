package com.ashmit.finalto_do

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NotesAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_notes, parent, false)
        return NotesViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentItem = notes[position]

        holder.tvName.text = currentItem.name
        holder.tvPriority.text = currentItem.priority
    }

    override fun getItemCount() = notes.size


    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.txt_name)
        val tvPriority: TextView = itemView.findViewById(R.id.txt_priority)

    }


}