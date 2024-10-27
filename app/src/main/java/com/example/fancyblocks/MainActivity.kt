package com.example.fancyblocks

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    private var numbers = mutableListOf(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            val restoredList = savedInstanceState.getIntegerArrayList("NUMBER_LIST")
            if (restoredList != null) {
                numbers = restoredList.toMutableList()
            }
        }

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        fab = findViewById(R.id.fab)

        val adapter = BlockListAdapter(this, numbers)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            val newNumber = (numbers.size + 1)

            adapter.addItem(newNumber)
            recyclerView.smoothScrollToPosition(numbers.size - 1);
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntegerArrayList("NUMBER_LIST", ArrayList(numbers))
    }
}
