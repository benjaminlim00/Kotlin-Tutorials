package com.example.numbersgamekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickRandomNumbers()
    }


    fun leftButtonClick(view: View) {
        checkIfCorrectAnswer(true)
    }

    fun rightButtonClick(view: View) {
        checkIfCorrectAnswer(false)

    }

    fun toNextAct(view: View) {
        val i = Intent(this@MainActivity, secondActivity::class.java)
        startActivity(i)


    }

    private fun checkIfCorrectAnswer(isLeft: Boolean) {
//        val left_button = findViewById<Button>(R.id.left_button)
//        val right_button = findViewById<Button>(R.id.right_button)
        val leftNum = left_button.text.toString().toInt()
        val rightNum = right_button.text.toString().toInt()

        if (isLeft) {
            if (leftNum > rightNum) {
                points++
                Toast.makeText(this, "you got it!", Toast.LENGTH_LONG)
            } else {
                points--
                Toast.makeText(this, "uhhh", Toast.LENGTH_LONG)

            }
        } else {
            if (leftNum < rightNum) {
                points++
                Toast.makeText(this, "you got it!", Toast.LENGTH_LONG)

            } else {
                points--
                Toast.makeText(this, "uhhhh", Toast.LENGTH_LONG)

            }
        }

        findViewById<TextView>(R.id.points).text = "Points: $points"
        pickRandomNumbers()
    }

    fun pickRandomNumbers() {
//        val leftButton = findViewById<Button>(R.id.left_button)
//        val rightButton = findViewById<Button>(R.id.right_button)


        val r = Random()
        var num1 = r.nextInt(10)
        var num2 = r.nextInt(10)
        while (num1 == num2) {
            var num2 = r.nextInt(10)
        }


        left_button.text = "$num1"
        right_button.text = "$num2"

    }
}
