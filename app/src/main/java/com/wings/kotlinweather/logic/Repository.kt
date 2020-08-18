package com.wings.kotlinweather.logic

import androidx.lifecycle.liveData
import com.wings.kotlinweather.logic.model.Place
import com.wings.kotlinweather.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 * @author -> Wings
 * @date   -> 2020/8/17
 * @email  -> ruanyandongai@gmail.com
              729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
           -> https://blog.csdn.net/qq_34681580
 */
object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {

        val result = try {
            val  placeResponse = WeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places;
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }

        emit(result)
    }

}