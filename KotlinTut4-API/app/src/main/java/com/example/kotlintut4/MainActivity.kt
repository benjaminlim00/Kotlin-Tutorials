package com.example.kotlintut4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }




//    {
//        "type": "success",
//        "value": {
//        "id": 342,
//        "joke": "Chuck Norris owns a chain of fast-food restaurants throughout the southwest. They serve nothing but barbecue-flavored ice cream and Hot Pockets.",
//        "categories": [
//
//        ]
//    }
    fun click(view: View) {
        Ion.with(this).load("http://api.icndb.com/jokes/random").asString()
            .setCallback { err, result ->
                Log.d("ben", "the data is \n$result")
                processChuckData(result)
            }
    }

    private fun processChuckData(result:String) {
        val json = JSONObject(result)
        val obj = json.getJSONObject("value")
        val joke = obj.getString("joke")

        joke_text.text = joke
    }

    fun catClick(view: View) {
        Ion.with(this)
            .load("http://thecatapi.com/api/images/get?format=json&size=med&results_per_page=8").asString()
            .setCallback { err, result ->
                Log.d("ben", "the data is \n$result")
                processCatData(result)
            }
    }

    private fun processCatData(result: String) {

        val arr = JSONObject("{\"images\": $result}")
            .getJSONArray("images")
        grid_layout.removeAllViews()


        for (i in 0 until  arr.length() - 1) {
            val url = arr.getJSONObject(i)
                .getString("url")

            val img = ImageView(this)
            img.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            grid_layout.addView(img)
            Picasso.get().load(url).into(img)
        }
    }
}
