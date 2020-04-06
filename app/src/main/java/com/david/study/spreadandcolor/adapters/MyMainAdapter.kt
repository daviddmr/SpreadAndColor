package com.david.study.spreadandcolor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.david.study.spreadandcolor.R

class MyMainAdapter(
    private val context: Context,
    private val itemList: Int
) : RecyclerView.Adapter<MyMainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMainViewHolder {
        val layoutInflater: View =
            LayoutInflater.from(context).inflate(R.layout.field_item, parent, false)

        return MyMainViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return itemList
    }

    override fun onBindViewHolder(holder: MyMainViewHolder, position: Int) {
    }
}

class MyMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val btField: Button = itemView.findViewById(R.id.bt_field)
}
