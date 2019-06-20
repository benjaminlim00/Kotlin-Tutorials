package com.example.kotlintut

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQ_CODE = 123  //1 to 65535

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1.text = "text has been changed!!"

    }


    fun onButtonClick(view: View) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivityForResult(intent, REQ_CODE)
    }

    //Intent? because it can be null
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        if (requestCode == REQ_CODE) {

            if (intent != null) {

                val name = intent.getStringExtra("word")
                Toast.makeText(this, "Got back the name: $name", Toast.LENGTH_LONG).show()
            }
        }
    }
}
