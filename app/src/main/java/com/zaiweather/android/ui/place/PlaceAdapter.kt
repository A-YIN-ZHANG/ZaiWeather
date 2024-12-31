package com.zaiweather.android.ui.place

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zaiweather.android.logic.model.Place
import com.zaiweather.android.R
import com.zaiweather.android.ui.weather.WeatherActivity

class PlaceAdapter (private val frament : PlaceFragment, private val placeList : List<Place>):
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>()
{
    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view)
    {
        val placeName = view.findViewById<TextView>(R.id.placeName)
        val placeAddress = view.findViewById<TextView>(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        val holder = ViewHolder(view)
        holder.view.setOnClickListener {
            val position = holder.adapterPosition
            val place = placeList[position]
            val activity = frament.activity
            if(activity is WeatherActivity){
                activity.findViewById<DrawerLayout>(R.id.drawerLayout).closeDrawers()
                activity.viewModel.locationLng = place.location.lng
                activity.viewModel.locationLat = place.location.lat
                activity.viewModel.placeName = place.name
                activity.refreshWeather()
            } else {
                val intent = Intent(parent.context,WeatherActivity::class.java).apply {
                    putExtra("location_lng",place.location.lng)
                    putExtra("location_lat",place.location.lat)
                    putExtra("place_name",place.name)
                }
                frament.startActivity(intent)
                activity?.finish()
            }
            frament.viewModel.savePlace(place)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.formatted_address
    }
    override fun getItemCount() = placeList.size
}