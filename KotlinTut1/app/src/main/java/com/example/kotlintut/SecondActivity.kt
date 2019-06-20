package com.example.kotlintut

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Handler().postDelayed({
            returnIntent()
        }, 5000)


    }

    fun returnIntent() {
        val intent = Intent()
        intent.putExtra("word", "ben")
        intent.putExtra("defn", "me")
        setResult(200, intent)
        finish()
    }


}
