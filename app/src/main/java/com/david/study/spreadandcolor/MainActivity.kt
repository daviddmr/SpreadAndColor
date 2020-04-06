package com.david.study.spreadandcolor

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.david.study.spreadandcolor.adapters.MyMainAdapter
import com.david.study.spreadandcolor.utils.SpanningGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var myMainAdapter: MyMainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val numberOfLines = 3.0
        val numberOfItems = numberOfLines.pow(2)

        rv_fields.setHasFixedSize(true)
        val gridLayoutManager = SpanningGridLayoutManager(this, numberOfLines.toInt())
        rv_fields.layoutManager = gridLayoutManager

        myMainAdapter = MyMainAdapter(this, numberOfItems.toInt(), onClickListener())
        rv_fields.adapter = myMainAdapter
    }

    private fun onClickListener(): View.OnClickListener {
        return View.OnClickListener { view ->
            val button = view as Button
            if (button.text == "Clicked") {
                button.text = ""
            } else {
                button.text = "Clicked"
            }
        }
    }
}