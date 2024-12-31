package com.zaiweather.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.zaiweather.android.logic.Repository
import com.zaiweather.android.logic.model.Location

class WeatherViewModel:ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLiveData = locationLiveData.switchMap {location ->
        Repository.refreshWeather(location.lng, location.lat)
    }
    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }
}