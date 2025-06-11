package com.example

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practicum.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val listView = findViewById<ListView>(R.id.listView)
        val backButton = findViewById<Button>(R.id.backButton)

        val items = intent.getStringArrayListExtra("items") ?: arrayListOf()
        val quantities = intent.getIntegerArrayListExtra("quantities") ?: arrayListOf()

        val displayList = ArrayList<String>()

        for (i in items.indices) {
            if (quantities[i] >= 2) {
                displayList.add("${items[i]} (Qty: ${quantities[i]})")
            }
        }

        if (displayList.isEmpty()) {
            displayList.add("No items with quantity >= 2")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, displayList)
        listView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }
    }
}
