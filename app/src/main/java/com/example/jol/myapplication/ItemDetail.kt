package com.example.jol.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(toolbar)
        val itemData = intent.getParcelableExtra<ItemData>("itemData")
        initializeData(itemData)
    }

    private fun initializeData(itemData: ItemData) {
        val itemImage = findViewById<ImageView>(R.id.itemImage)
        val itemDescription: TextView = findViewById(R.id.itemDetail)
        itemImage.setImageResource(itemData.image)
        itemDescription.text = itemData.description
    }

}
