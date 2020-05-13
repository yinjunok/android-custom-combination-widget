package com.example.customcombinationwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val header = findViewById<Header>(R.id.header)
        header.setTitle("自定义标题")
        header.setBackClickListener(View.OnClickListener {
            Log.d("header", "setBackClickListener")
        })
        header.setButtonClickListener(View.OnClickListener {
            Log.d("header", "setButtonClickListener")
        })
        header.setClickCountListener {
            Log.d("header", "$it")
        }
    }
}
