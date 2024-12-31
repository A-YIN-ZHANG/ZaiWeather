package com.zaiweather.android.logic.network

import com.zaiweather.android.ZaiWeatherApplication
import com.zaiweather.android.logic.model.DailyResponse
import com.zaiweather.android.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${ZaiWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<RealtimeResponse>
    //https://api.caiyunapp.com/v2.5/umjyUvcRBZ15PtVo/108.948024,34.263161/daily?dailysteps=1
    @GET("v2.5/${ZaiWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>

}