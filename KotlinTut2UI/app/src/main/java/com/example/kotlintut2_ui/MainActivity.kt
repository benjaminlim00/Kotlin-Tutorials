package com.example.kotlintut2_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val COUNTRIES = listOf("Australia",
        "Brazil",
        "China",
        "Egypt",
        "France",
        "Germany",
        "Italy",
        "Japan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val flag = layoutInflater.inflate(R.layout.flag, grid_of_flags)
//
//
//        layoutInflater.inflate(R.layout.flag, grid_of_flags)
//        layoutInflater.inflate(R.layout.flag, grid_of_flags)
//        layoutInflater.inflate(R.layout.flag, grid_of_flags)

        for (country in COUNTRIES) {
            createFlag(country)

        }

    }


    fun createFlag(countryName: String) {

        val flag = layoutInflater.inflate(R.layout.flag, null)


        val image = flag.findViewById<TextView>(R.id.flag_image)
        val countryNameView = flag.findViewById<TextView>(R.id.country_name)
        val visitedBox = flag.findViewById<CheckBox>(R.id.visited_box)
        val button = flag.findViewById<Button>(R.id.button)
        button.setOnClickListener {
//            Toast.makeText(this@MainActivity, "you clicked on $countryName", Toast.LENGTH_SHORT).show()

            showCountryInfo(countryName)
        }




//        val countryName2 = countryName.toLowerCase().replace(" ", "")
//        val imageID = resources.getIdentifier(countryName2, "drawable", packageName)
//        image.setImageResource(imageID)
        image.text = countryName


        countryNameView.text = countryName





        //add the end show the grid of flags
        grid_of_flags.addView(flag)

    }


    fun showCountryInfo(countryName: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Info about $countryName")
        builder.setMessage("You clicked $countryName")


        builder.setPositiveButton("OK") { _, _ ->


        }


        val dialog = builder.create()
        dialog.show()
    }

}
