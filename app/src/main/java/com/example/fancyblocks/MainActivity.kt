package com.example.fancyblocks

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        fab = findViewById(R.id.fab)
        val numbers: ArrayList<Int> = ArrayList<Int>()
        val adapter = BlockListAdapter()
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        fab.setOnClickListener {
            val newNumber = (numbers.size + 1)

            numbers.add(newNumber)
            adapter.addItem(newNumber)
        }
    }
}
