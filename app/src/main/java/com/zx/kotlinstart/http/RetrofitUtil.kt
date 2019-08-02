package com.zx.kotlinstart.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * description：
 * author：bux on 2019/8/2 14:18
 * email: 471025316@qq.com
 */
object RetrofitUtil {


    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.wanandroid.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build()
        )
        .build()


    val apiService = retrofit.create(ApiService::class.java)


}




