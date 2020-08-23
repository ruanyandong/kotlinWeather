package com.wings.kotlinweather.logic.dao

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.wings.kotlinweather.WeatherApp
import com.wings.kotlinweather.logic.model.Place

/**
 * @author -> Wings
 * @date   -> 2020/8/23
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
object PlaceDao {

    private fun sharedPreference(): SharedPreferences {
        return WeatherApp.sContext.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
    }

    fun isPlaceSaved(): Boolean {
        return sharedPreference().contains("place")
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreference().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun savePlace(place: Place) : Unit{
        sharedPreference().edit {
            putString("place",Gson().toJson(place))
        }
    }
}