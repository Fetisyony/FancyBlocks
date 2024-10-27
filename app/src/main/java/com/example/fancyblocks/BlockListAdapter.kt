package com.example.fancyblocks

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class BlockListAdapter(private val context: Context, private var items: MutableList<Int>) : RecyclerView.Adapter<BlockListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockListViewHolder {
        return BlockListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.block_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BlockListViewHolder, position: Int) {
        holder.bind(items[position])

        if (position % 2 == 0)
            holder.itemView.findViewById<MaterialCardView>(R.id.card).setCardBackgroundColor(ContextCompat.getColor(context, R.color.blue))
        else
            holder.itemView.findViewById<MaterialCardView>(R.id.card).setCardBackgroundColor(ContextCompat.getColor(context, R.color.red))
    }

    fun setItems(list: MutableList<Int>) {
        items = list
        notifyItemRangeChanged(0, list.size)
    }
    fun addItem(list: Int) {
        items.add(list)
        notifyItemInserted(items.size - 1)
    }
}