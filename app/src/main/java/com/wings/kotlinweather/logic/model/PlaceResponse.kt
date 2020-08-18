package com.wings.kotlinweather.logic.model

import com.google.gson.annotations.SerializedName


/**
 * @author -> Wings
 * @date   -> 2020/8/17
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
data class PlaceResponse(val status: String, val places: List<Place>)
data class Place(val name: String, val location: Location, @SerializedName("formatted_address")val address: String)
data class Location(val lng: String, val lat: String)