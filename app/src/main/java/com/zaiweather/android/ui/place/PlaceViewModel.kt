package com.zaiweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.zaiweather.android.logic.Repository
import com.zaiweather.android.logic.model.Place

class PlaceViewModel :ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = searchLiveData.switchMap{ query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlaces() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}