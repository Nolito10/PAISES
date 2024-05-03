package com.countriesapp10.paises

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.countriesapp10.paises.databinding.ActivityUserBinding


class UserActivity: AppCompatActivity() {


    private lateinit var  binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Country_name = intent.getStringExtra("Pais")
        val Country_Continent = intent.getStringExtra("Comtinente")
        val Capital = intent.getStringExtra("Capital")
        val Iso_2 = intent.getStringExtra("ISO2")
        val Iso_3 = intent.getStringExtra("ISO3")
        val Prefijo = intent.getStringExtra("Prefijo")
        val ImageId = intent.getIntExtra("Imagen", R.drawable.nicaragua)

        binding.countryname.text= Country_name
        binding.countryContinent.text = Country_Continent
        binding.capital.text = Capital
        binding.iso2.text = Iso_2
        binding.iso3.text = Iso_3
        binding.prefijo.text = Prefijo
        binding.flagPic.setImageResource(ImageId)
    }
}