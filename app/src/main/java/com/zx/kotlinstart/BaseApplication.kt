package com.zx.kotlinstart

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * description：
 * author：bux on 2019/8/2 11:28
 * email: 471025316@qq.com
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this;
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context;

        public fun getContext():Context {
            return context;
        }

    }

}