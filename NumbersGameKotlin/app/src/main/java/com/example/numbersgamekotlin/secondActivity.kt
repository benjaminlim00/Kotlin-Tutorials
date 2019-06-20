package com.example.numbersgamekotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.second_activity.*


class secondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
//
//        spinner.onItemSelectedListener {
//            _,_,index,_ -> val name = when (index) {
//            0 -> "ben"
//            1 -> "jon"
//            2 -> "jerry"
//            else -> "tom"
//
//        }
//
//            Toast.makeText(this, name, Toast.LENGTH_LONG)
//        }
    }

    fun toNextAct(view: View) {
        startActivity(Intent(this@secondActivity, thirdActivity::class.java))
    }

}