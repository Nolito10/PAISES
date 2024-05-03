package com.countriesapp10.paises

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.countriesapp10.paises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<Countries>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val Imageid = intArrayOf(

            R.drawable.nicaragua,
            R.drawable.italia,
            R.drawable.madagascar,
            R.drawable.south_korea,
        )

        val country_name = arrayOf(
             "Nicaragua",
            "Italia",
            "Madagascar",
            "South Korea"
        )
        val country_Continent = arrayOf(
            "America",
            "Europa",
            "Africa",
            "Asia"
        )
        val capital = arrayOf(
            "Managua",
            "Roma",
            "Antananarivo",
            "Seoul"
        )
        val iso_2 = arrayOf(
            "NIC",
            "IT",
            "MG",
            "KR"
        )
        val iso_3 = arrayOf(
            "NIC",
            "ITA",
            "MDG",
            "KOR"
        )
        val prefijo = arrayOf(
            "+505",
            "+39",
            "+261",
            "+82"
        )

        userArrayList = ArrayList()

        for (i in country_name.indices){

            val countries = Countries(country_name[i],country_Continent[i], iso_2[i], iso_3[i], capital[i], prefijo[i],
                Imageid[i])
            userArrayList.add(countries)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter (this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val Country_name = country_name[position]
            val Country_Continent = country_Continent[position]
            val Capital = capital [position]
            val Iso_2 = iso_2 [position]
            val Iso_3 = iso_3 [position]
            val Prefijo = prefijo [position]
            val ImageId = Imageid[position]

            val i = Intent(this, UserActivity::class.java)

            i.putExtra("Pais",Country_name)
            i.putExtra("Continente", Country_Continent)
            i.putExtra("Capital",Capital)
            i.putExtra("Iso_2", Iso_2)
            i.putExtra("Iso_3", Iso_3)
            i.putExtra("Prefijo", Prefijo)
            i.putExtra("Imagen", ImageId)

            startActivity(i)
        }
    }
}