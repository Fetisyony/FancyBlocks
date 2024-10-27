package com.example.fancyblocks

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class BlockListViewHolder(view: View) : ViewHolder(view) {
    private val text = view.findViewById<TextView>(R.id.item_number_tv)

    fun bind(number: Int) {
        text.text = "$number"
    }
}