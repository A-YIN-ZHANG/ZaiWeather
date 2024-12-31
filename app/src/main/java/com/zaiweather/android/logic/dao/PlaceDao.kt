package com.zaiweather.android.logic.dao

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.zaiweather.android.ZaiWeatherApplication
import com.zaiweather.android.logic.model.Place

object PlaceDao {
    fun savePlace(place: Place) {
        val editor = sharedPreferences().edit()
        editor.putString("place", Gson().toJson(place))
        editor.apply()  // 使用 apply() 来提交更改
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")
    private fun sharedPreferences() = ZaiWeatherApplication.getContext().getSharedPreferences("zai_weatrher", Context.MODE_PRIVATE)
}