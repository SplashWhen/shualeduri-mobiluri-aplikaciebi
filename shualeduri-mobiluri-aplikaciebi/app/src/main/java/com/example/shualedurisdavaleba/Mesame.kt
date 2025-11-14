package com.example.shualedurisdavaleba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Mesame : AppCompatActivity() {

    private var quantity = 1
    private var productPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mesamegverdi)

        productPrice = intent.getIntExtra("product_price", 0)

        val backButton = findViewById<ImageButton>(R.id.btn_back)
        val plusButton = findViewById<ImageButton>(R.id.plus_button)
        val minusButton = findViewById<ImageButton>(R.id.minus_button)
        val tvQuantity = findViewById<TextView>(R.id.tv_quantity)
        val tvTotal = findViewById<TextView>(R.id.tv_total)
        val placeOrderButton = findViewById<Button>(R.id.btn_place_order)

        tvTotal.text = "${productPrice * quantity} $"

        backButton.setOnClickListener {
            val intent = Intent(this, meore::class.java)
            startActivity(intent)
            finish()
        }

        plusButton.setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
            tvTotal.text = "${productPrice * quantity} $"
        }

        minusButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                tvQuantity.text = quantity.toString()
                tvTotal.text = "${productPrice * quantity} $"
            }
        }

        placeOrderButton.setOnClickListener {
            val intent = Intent(this, Meotxe::class.java)
            startActivity(intent)
            finish()
        }
    }
}
