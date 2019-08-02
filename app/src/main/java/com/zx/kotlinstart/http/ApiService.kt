package com.zx.kotlinstart.http

import com.zx.kotlinstart.http.bean.BaseBean
import com.zx.kotlinstart.http.bean.HomeBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * description：
 * author：bux on 2019/8/2 11:51
 * email: 471025316@qq.com
 */
interface ApiService {

    @GET("article/list/{userId}/json")
    fun getHomeData(@Path("userId") userId: String): Call<BaseBean<HomeBean>>
}