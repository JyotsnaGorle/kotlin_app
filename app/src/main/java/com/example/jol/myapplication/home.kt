package com.example.jol.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_data.view.*
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader


class home : AppCompatActivity() {

    lateinit var adapter: ItemGridAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val grid = findViewById<GridView>(R.id.grid)

        val raw = resources.openRawResource(R.raw.itemlist)
        val rd = BufferedReader(InputStreamReader(raw))
        val gson = Gson()
        val list: ItemDataList = gson.fromJson(rd, ItemDataList::class.java)

        val listWithImages = list.itemList.map {
            it.copy(image = resources.getIdentifier(it.imagePath, "drawable", packageName))
        }
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList)
        adapter = ItemGridAdapter(this, listWithImages as ArrayList<ItemData>)
        grid.adapter = adapter
    }

    class ItemGridAdapter(context: Context, var itemList: ArrayList<ItemData>) : BaseAdapter() {
        var context: Context? = context

        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val item = this.itemList[position]
            val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = inflator.inflate(R.layout.item_data, null)
            itemView.itemName.text = item.name
            itemView.imgItem.setImageResource(item.image)
            itemView.setOnClickListener {
                val intent = Intent(this.context, itemDetail::class.java)
                intent.putExtra("key", "Kotlin")
                intent.putExtra("itemData", item)
                startActivity(this.context!!, intent, null)
            }
            return itemView
        }

        override fun getItem(position: Int): Any {
            return this.itemList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return itemList.size
        }

    }
}


