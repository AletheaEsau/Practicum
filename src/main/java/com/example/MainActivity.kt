package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practicum.R

class MainActivity : AppCompatActivity() {
    private val items = ArrayList<String>()
    private val categories = ArrayList<String>()
    private val quantities = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemNameInput = findViewById<EditText>(R.id.itemName)
        val categoryInput = findViewById<EditText>(R.id.category)
        val quantityInput = findViewById<EditText>(R.id.quantity)
        val commentInput = findViewById<EditText>(R.id.comment)

        val addButton = findViewById<Button>(R.id.addButton)
        val viewButton = findViewById<Button>(R.id.viewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        addButton.setOnClickListener {
            val item = itemNameInput.text.toString()
            val category = categoryInput.text.toString()
            val quantityStr = quantityInput.text.toString()
            val comment = commentInput.text.toString()

            if (item.isEmpty() || category.isEmpty() || quantityStr.isEmpty() || comment.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val quantity = quantityStr.toIntOrNull()
            if (quantity == null || quantity < 1) {
                Toast.makeText(this, "Enter a valid quantity (>= 1)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            items.add(item)
            categories.add(category)
            quantities.add(quantity)
            comments.add(comment)

            Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()

            // Clear input
            itemNameInput.text.clear()
            categoryInput.text.clear()
            quantityInput.text.clear()
            commentInput.text.clear()
        }

        viewButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putStringArrayListExtra("items", items)
            intent.putStringArrayListExtra("categories", categories)
            intent.putIntegerArrayListExtra("quantities", quantities)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}
