package com.example.jol.myapplication

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
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_data.view.*


class home : AppCompatActivity() {

    var itemList = ArrayList<ItemData>()
    var adapter: ItemGridAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        val grid = findViewById<GridView>(R.id.grid);
        itemList.add(ItemData("element1", "element1", R.drawable.ic_launcher_background))
        itemList.add(ItemData("element1", "element1", R.drawable.ic_launcher_background))
        itemList.add(ItemData("element1", "element1", R.drawable.ic_launcher_background))
        itemList.add(ItemData("element1", "element1", R.drawable.ic_launcher_background))
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList)
        adapter = ItemGridAdapter(this, itemList)
        grid.adapter = adapter
    }

    class ItemGridAdapter : BaseAdapter {
        var itemList = ArrayList<ItemData>()
        var context: Context? = null

        constructor(context: Context, itemList: ArrayList<ItemData>) {
            this.context = context
            this.itemList = itemList
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val item = this.itemList[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var itemView = inflator.inflate(R.layout.item_data, null)
            itemView.itemName.text = item.name
            itemView.imgItem.setImageResource(item.image!!)
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


