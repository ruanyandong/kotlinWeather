package com.wings.kotlinweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author -> Wings
 * @date   -> 2020/8/17
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
class WeatherApp : Application(){

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var sContext : Context

        // 如果只读属性的值在编译期是已知的，那么可以使用 const 修饰符将其标记为编译期常量。
        // 这种属性需要满足以下要求：
        //    位于顶层或者是 object 声明 或 companion object 的一个成员
        //    以 String 或原生类型值初始化
        //    没有自定义 getter
        const val TOKEN = "2JyuhYKnVmOXMkz9"
    }

    override fun onCreate() {
        super.onCreate()
        sContext = applicationContext
    }

}