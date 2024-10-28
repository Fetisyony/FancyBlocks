package com.example.fancyblocks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var actionButton: FloatingActionButton

    // default list of items
    private var numbers = mutableListOf(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            val restoredList = savedInstanceState.getIntegerArrayList("NUMBER_LIST")
            if (restoredList != null)
                numbers = restoredList.toMutableList()
        }

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.blocks_rv)
        actionButton = findViewById(R.id.fab)

        val adapter = BlockListAdapter(this, numbers)
        recyclerView.adapter = adapter

        actionButton.setOnClickListener {
            val newNumber = (numbers.size + 1)

            adapter.addItem(newNumber)
            recyclerView.scrollToPosition(numbers.size - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntegerArrayList("NUMBER_LIST", ArrayList(numbers))
    }
}
