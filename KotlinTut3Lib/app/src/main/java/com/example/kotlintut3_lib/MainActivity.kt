package com.example.kotlintut3_lib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*



class Foo {
    fun bar() {
        //can be accessed here
        MainActivity.WEBSITE_DIRECTORY

    }
}


class MainActivity : AppCompatActivity() {


    //equivalent of static
    companion object {
        val WEBSITE_DIRECTORY = "http://www.martystepp.com/dogs/"
        private val LIST_OF_FILES = "files.txt"
    }

//    private lateinit var allImages : List<String>
    private var allImages = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Picasso.get().load("http://www.martystepp.com/dogs/daisy-15.jpg")
//            .resize(600,1000).rotate(90f).into(dog_view)


        Ion.with(this)
            .load("$WEBSITE_DIRECTORY/$LIST_OF_FILES")
            .asString()
            .setCallback { err, result ->
                //code to process the result
                allImages = result.split("\n")
                puppy_spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allImages)

                show_button.isEnabled=true
            }

    }

    fun onClickShow(view: View) {
        //display currently selected image in spinner
//        val pups = resources.getStringArray(R.array.puppy_images)
//        val index = puppy_spinner.selectedItemPosition
//
//        val pup = pups[index]


        val index = puppy_spinner.selectedItemPosition
        val pup = allImages[index]


        YoYo.with(Techniques.Wobble)
            .duration(2000)
            .playOn(show_button)


        Picasso.get().load("$WEBSITE_DIRECTORY/$pup").into(dog_view)




    }
}
