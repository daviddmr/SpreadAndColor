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

    fun flipSelectedPiece(position: Int, numberOfLines: Double) {
        val piece = pieceList[position]
        flipAdjacentPieces(piece.line, piece.column, 1, 1, numberOfLines)
    }

    private fun flipAdjacentPieces(line: Int, column: Int, floor: Int, ceil: Int, numberOfLines: Double) {
        for (i in line - floor..line + ceil) {
            for (j in column - floor..column + ceil) {
                val position = pieceList.indexOfFirst { piece ->
                    (piece.line == i && piece.column == j)
                }

                if (position != -1) {
                    flipOnePiece(position)
                }
            }
        }

        if (floor < numberOfLines && ceil < numberOfLines) {
            flipAdjacentPieces(line, column, floor + 1, ceil + 1, numberOfLines)
        }
    }

    private fun flipOnePiece(position: Int) {
        val piece = pieceList[position]
        if (!piece.isSelected) {
            piece.isSelected = true
            notifyItemChanged(position)
        }
    }
}

class MyMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val btField: Button = itemView.findViewById(R.id.bt_field)
}
