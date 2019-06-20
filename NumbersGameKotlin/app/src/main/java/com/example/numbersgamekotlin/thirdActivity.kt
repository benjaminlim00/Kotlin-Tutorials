package com.example.numbersgamekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.third_activity.*
import java.util.*
import kotlin.collections.ArrayList


class thirdActivity : AppCompatActivity() {
    private val defns = ArrayList<String>()
    private lateinit var myAdapter : ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        setupList()
        definitions_list.setOnItemClickListener { _,_,index,_ ->
            defns.removeAt(index)
            myAdapter.notifyDataSetChanged()

        }
    }



    private fun setupList() {

        val ls = ArrayList<String>()
        ls.add("Hello")
        ls.add("Goodbye")
        ls.add("Marty")


        val rand = Random()
        val index = rand.nextInt(ls.size)
        val word = ls[index]
        the_word.text = word



        //pick random definitions

        defns.add("a greeting")
        defns.add("the president")
        defns.add("a duck")
        defns.add("white")
        defns.add("black")
        defns.add("a place on earth")
        defns.shuffle()

        myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, defns)

        definitions_list.adapter = myAdapter
    }


}