package com.wings.kotlinweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author -> Wings
 * @date   -> 2020/8/17
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
object ServiceFactory {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass : Class<T>) : T = retrofit.create(serviceClass)

    // 内联函数支持具体化的类型参数  使用 reified 修饰符来限定类型参数
    inline fun <reified T> create():T = create(T::class.java)

}