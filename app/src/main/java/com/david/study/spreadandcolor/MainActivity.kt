package com.david.study.spreadandcolor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.SimpleItemAnimator
import com.david.study.spreadandcolor.adapters.MyMainAdapter
import com.david.study.spreadandcolor.utils.SpanningGridLayoutManager
import com.david.study.spreadandcolor.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow


class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var myMainAdapter: MyMainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val numberOfLines = 3.0
        val numberOfItems = numberOfLines.pow(2).toInt()
        val pieceList = viewModel.getPieceListMapped(numberOfLines, numberOfItems)

        rv_fields.setHasFixedSize(true)
        //Disable animation during notifyItemChanged()
        (rv_fields.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        val gridLayoutManager = SpanningGridLayoutManager(this, numberOfLines.toInt())
        rv_fields.layoutManager = gridLayoutManager

        myMainAdapter = MyMainAdapter(this, pieceList, this)
        rv_fields.adapter = myMainAdapter
    }

    override fun onPieceClickListener(position: Int) {
        myMainAdapter.flipSelectedPiece(position)
    }
}

interface OnClickListener {
    fun onPieceClickListener(position: Int)
}