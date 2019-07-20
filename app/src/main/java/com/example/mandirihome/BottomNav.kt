package com.example.mandirihome

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.graphics.Typeface
import android.view.View


@SuppressLint("Registered")
open class BottomNavActivity : AppCompatActivity()  {


    protected val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setContentVis('a')
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                setContentVis('b')
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                setContentVis('c')
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                setContentVis('d')
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    fun fontChange(txt : TextView){
        val typeface = Typeface.createFromAsset(assets, "fonts/myriadpro.ttf")
        txt.typeface = typeface
    }

    fun setContentVis(value : Char){
        if (value == 'a'){
            findViewById<View>(R.id.page_content_a).setVisibility(View.VISIBLE)
            findViewById<View>(R.id.page_content_b).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_c).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_d).setVisibility(View.GONE)
        }
        else if (value == 'b'){
            findViewById<View>(R.id.page_content_a).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_b).setVisibility(View.VISIBLE)
            findViewById<View>(R.id.page_content_c).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_d).setVisibility(View.GONE)
        }
        else if (value == 'c'){
            findViewById<View>(R.id.page_content_a).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_b).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_c).setVisibility(View.VISIBLE)
            findViewById<View>(R.id.page_content_d).setVisibility(View.GONE)
        }
        else if (value == 'd'){
            findViewById<View>(R.id.page_content_a).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_b).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_c).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_d).setVisibility(View.VISIBLE)
        }
        else{
            findViewById<View>(R.id.page_content_a).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_b).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_c).setVisibility(View.GONE)
            findViewById<View>(R.id.page_content_d).setVisibility(View.GONE)
        }
    }
}