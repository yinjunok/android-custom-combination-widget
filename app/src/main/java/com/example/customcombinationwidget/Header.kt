package com.example.customcombinationwidget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Header: ConstraintLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.Header)
        headerText = typedArray?.getString(R.styleable.Header_header_text) ?: "标题"
        title.text = headerText
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val back: ImageView
    private val title: TextView
    private val button: Button
    private lateinit var headerText: String
    private var count = 0
    private var clickCountListener: (c: Int) -> Unit = {}
    init {
        LayoutInflater.from(context).inflate(R.layout.header, this, true)
        back = findViewById(R.id.back)
        title = findViewById(R.id.title)
        button = findViewById(R.id.button)
        this.setOnClickListener {
            clickCountListener(count)
        }
    }

    fun setTitle(text: String) {
        title.text = text
    }

    fun setButtonText(text: String) {
        button.text = text
    }

    fun setButtonClickListener(listener: View.OnClickListener) {
        button.setOnClickListener {
            listener.onClick(it)
            count++
        }
    }

    fun setBackClickListener(listener: View.OnClickListener) {
        back.setOnClickListener {
            listener.onClick(it)
            count++
        }
    }

    fun setClickCountListener(listener: (c: Int) -> Unit) {
        clickCountListener = listener
    }
}
