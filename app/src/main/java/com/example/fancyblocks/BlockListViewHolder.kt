package com.example.fancyblocks

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.card.MaterialCardView

class BlockListViewHolder(view: View) : ViewHolder(view) {
    private val cardView = itemView.findViewById<MaterialCardView>(R.id.card)
    private val text = view.findViewById<TextView>(R.id.item_number_tv)

    fun bind(number: Int, context: Context) {
        text.text = number.toString()

        val cardColor = if (number % 2 == 1) R.color.blue else R.color.red

        cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardColor))
    }
}