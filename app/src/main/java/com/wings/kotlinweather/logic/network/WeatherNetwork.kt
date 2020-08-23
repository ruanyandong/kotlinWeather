package com.wings.kotlinweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author -> Wings
 * @date   -> 2020/8/17
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
object WeatherNetwork {

    // 也可以这么写
    // private val weatherService = ServiceFactory.create<WeatherService>()
    private val weatherService = ServiceFactory.create(WeatherService::class.java)

    /**
     * 查询城市
     */
    suspend fun searchPlaces(query: String) = weatherService.searchPlaces(query).await()

    /**
     * 得到最近几天的天气
     */
    suspend fun getDailyWeather(lng: String, lat: String) =
        weatherService.getDailyWeather(lng, lat).await()

    /**
     * 获取实时天气
     */
    suspend fun getRealtimeWeather(lng: String, lat: String) =
        weatherService.getRealtimeWeather(lng, lat).await()

    // 挂起函数必须在协程或者另外一个挂起函数中调用
    private suspend fun <T> Call<T>.await(): T {
        // suspendCoroutine只能在 挂起函数 或者 协程作用域 中调用
        // 执行时会挂起当前协程，把内部代码放到线程中执行，执行完后resume等方法又会唤起协程
        return suspendCoroutine {

                continuation ->
            enqueue(object : Callback<T> {

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body)
                    } else {
                        continuation.resumeWithException(RuntimeException(" response body is null"))
                    }
                }
            })
        }
    }

}