package com.example.today

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {
    private val cartItems = mutableListOf<CartItem>()
    private lateinit var cartAdapter: ArrayAdapter<CartItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val itemNameEditText = findViewById<EditText>(R.id.itemNameEditText)
        val itemPriceEditText = findViewById<EditText>(R.id.itemPriceEditText)
        val addToCartButton = findViewById<Button>(R.id.addToCartButton)
        val cartListView = findViewById<ListView>(R.id.cartListView)

        cartAdapter = ArrayAdapter(this, R.layout.cart_item, R.id.itemNameTextView, cartItems)
        cartListView.adapter = cartAdapter

        addToCartButton.setOnClickListener {
            val itemName = itemNameEditText.text.toString()
            val itemPriceStr = itemPriceEditText.text.toString()

            if (itemName.isNotEmpty() && itemPriceStr.isNotEmpty()) {
                val itemPrice = itemPriceStr.toDouble()
                val newItem = CartItem(itemName, itemPrice)
                cartItems.add(newItem)
                cartAdapter.notifyDataSetChanged()

                itemNameEditText.text.clear()
                itemPriceEditText.text.clear()
            } else {
                Toast.makeText(this, "Please enter valid item name and price.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}