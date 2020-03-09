package com.renatoramos.rickandmorty.common.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

class ResizableImageView : AppCompatImageView {

    private var ratio = 1.5f

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
        defStyleAttr)

    fun setRatio(ratio: Float) {
        this.ratio = ratio
        invalidate()
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = (width / ratio).toInt()
        setMeasuredDimension(width, height)
    }
}