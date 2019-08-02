package com.zx.kotlinstart.http.bean

/**
 * description：
 * author：bux on 2019/8/2 12:00
 * email: 471025316@qq.com
 */
 class BaseBean<T>{
    var data: T?=null
    var errorCode: Int=0
    var errorMsg: String=""
}
