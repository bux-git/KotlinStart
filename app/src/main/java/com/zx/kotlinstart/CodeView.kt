package com.zx.kotlinstart

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * description：
 * author：bux on 2019/8/1 18:49
 * email: 471025316@qq.com
 */
class CodeView : AppCompatTextView {

    constructor(context: Context?) :  this(context,null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){

    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)



}