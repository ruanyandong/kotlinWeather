package com.wings.kotlinweather.logic.model

/**
 * @author -> Wings
 * @date   -> 2020/8/19
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)