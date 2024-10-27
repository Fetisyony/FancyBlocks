package com.example.fancyblocks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BlockListAdapter() : RecyclerView.Adapter<BlockListViewHolder>() {
    private var items = ArrayList<Int>()

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
    }

    fun setItems(list: ArrayList<Int>) {
        items = list
        notifyItemRangeChanged(0, list.size)
    }
    fun addItem(list: Int) {
        items.add(list)
        notifyItemInserted(items.size - 1)
    }
}