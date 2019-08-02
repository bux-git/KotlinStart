package com.zx.kotlinstart

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast

/**
 * description：
 * author：bux on 2019/8/2 11:33
 * email: 471025316@qq.com
 */
object Utils {

    fun showToast(msg: String) {
        Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT).show()
    }

    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics)

    }
}