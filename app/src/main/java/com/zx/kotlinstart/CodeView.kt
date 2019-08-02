package com.zx.kotlinstart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import kotlin.random.Random

/**
 * description：
 * author：bux on 2019/8/1 18:49
 * email: 471025316@qq.com
 */
class CodeView : AppCompatTextView {

    var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG);
    val codes= arrayOf("Java","php","c#","python","javascript","swift","c","c++")


    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)

        gravity = Gravity.CENTER
        setPadding(12, 12, 12, 12)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextColor(getContext().getColor(R.color.colorAccent))
            setBackgroundColor(getContext().getColor(R.color.colorPrimaryDark))
        }
        mPaint.strokeWidth=3f

        setOnClickListener(object :OnClickListener{
            override fun onClick(v: View?) {
                setText(codes[Random.nextInt(codes.size)])

            }

        })
    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, height / 2f, width.toFloat(), height.toFloat()/2, mPaint)
    }




}