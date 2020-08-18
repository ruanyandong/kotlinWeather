package com.wings.kotlinweather.logic.network

import com.wings.kotlinweather.WeatherApp
import com.wings.kotlinweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author -> Wings
 * @date   -> 2020/8/17
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
interface WeatherService {

    @GET("v2/place?token=${WeatherApp.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String) : Call<PlaceResponse>

}