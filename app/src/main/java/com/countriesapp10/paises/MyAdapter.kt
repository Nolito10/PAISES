package com.countriesapp10.paises

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Countries>) :
    ArrayAdapter<Countries>(context, R.layout.list_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            val inflater: LayoutInflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.list_item, parent, false)
        }

        val imageView: ImageView = view!!.findViewById(R.id.flag_pic)
        val countryname: TextView = view.findViewById(R.id.CountryName)

        imageView.setImageResource(arrayList[position].Imageid)
        countryname.text = arrayList[position].Country_name

        return view
    }
}
