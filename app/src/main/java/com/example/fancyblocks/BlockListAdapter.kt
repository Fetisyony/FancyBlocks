package com.example.fancyblocks

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView

class BlockListAdapter(private val context: Context, private var items: MutableList<Int>) : RecyclerView.Adapter<BlockListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockListViewHolder {
        return BlockListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.block_view, parent, false)
        )
    }

    override fun onViewAttachedToWindow(holder: BlockListViewHolder) {
        super.onViewAttachedToWindow(holder)

        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.appear)
        holder.itemView.startAnimation(animation)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BlockListViewHolder, position: Int) {
        holder.bind(items[position], context)
    }

    fun addItem(list: Int) {
        items.add(list)
        notifyItemInserted(items.size - 1)
    }
}
