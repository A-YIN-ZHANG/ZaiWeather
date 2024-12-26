package com.zaiweather.android.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zaiweather.android.logic.model.Place
import com.zaiweather.android.R
class PlaceAdapter (private val frament : Fragment, private val placeList : List<Place>):
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>()
{
    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view)
    {
        val placeName = view.findViewById<TextView>(R.id.placeName)
        val placeAddress = view.findViewById<TextView>(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.formatted_address
    }
    override fun getItemCount() = placeList.size
}