package com.example.fancyblocks

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

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

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BlockListViewHolder, position: Int) {
        holder.bind(items[position])

        val cardView = holder.itemView.findViewById<MaterialCardView>(R.id.card)
        if (position % 2 == 0)
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.blue))
        else
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.red))
    }

    fun addItem(list: Int) {
        items.add(list)
        notifyItemInserted(items.size - 1)
    }
}
