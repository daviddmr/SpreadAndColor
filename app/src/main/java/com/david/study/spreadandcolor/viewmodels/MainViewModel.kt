package com.david.study.spreadandcolor.viewmodels

import androidx.lifecycle.ViewModel
import com.david.study.spreadandcolor.models.Piece
import kotlin.math.ceil
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {

    fun getPieceListMapped(numberOfLines: Double, numberOfItems: Int): MutableList<Piece> {

        val pieceList = mutableListOf<Piece>()

        for (i in 1..numberOfItems) {
            val line: Int = ceil(i / numberOfLines).roundToInt()
            val mod: Double = i % numberOfLines
            val column: Int = if (mod.toInt() == 0) numberOfLines.toInt() else mod.toInt()

            pieceList.add(Piece(line, column, false))
        }

        return pieceList
    }
}