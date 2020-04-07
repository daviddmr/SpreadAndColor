package com.david.study.spreadandcolor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.david.study.spreadandcolor.OnClickListener
import com.david.study.spreadandcolor.R
import com.david.study.spreadandcolor.models.Piece

class MyMainAdapter(
    private val context: Context,
    private val pieceList: List<Piece>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<MyMainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMainViewHolder {
        val layoutInflater: View =
            LayoutInflater.from(context).inflate(R.layout.field_item, parent, false)

        return MyMainViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return pieceList.size
    }

    override fun onBindViewHolder(holder: MyMainViewHolder, position: Int) {
        holder.btField.setOnClickListener {
            listener.onPieceClickListener(position)
        }

        if (pieceList[position].isSelected) {
            holder.btField.text = "Clicked"
        } else {
            holder.btField.text = ""
        }
    }

    fun flipPiece(position: Int) {
        val piece = pieceList[position]
        piece.isSelected = !piece.isSelected
        notifyItemChanged(position)
    }
}

class MyMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val btField: Button = itemView.findViewById(R.id.bt_field)
}
