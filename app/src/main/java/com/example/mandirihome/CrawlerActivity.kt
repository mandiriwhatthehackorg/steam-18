package com.example.mandirihome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.view.View.OnTouchListener
import android.widget.Button
import androidx.core.view.marginLeft


class CrawlerActivity : AppCompatActivity() {

    private lateinit var leftButton : ImageButton
    private lateinit var rightButton : ImageButton
    private lateinit var takeButton : Button
    private lateinit var crawler : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crawler)
        leftButton = findViewById(R.id.left_button)
        rightButton = findViewById(R.id.right_button)
        crawler = findViewById(R.id.crawler)
        takeButton = findViewById(R.id.take_button)

        takeButton.setOnClickListener {
            for (i in 0..20){
                Handler().postDelayed(
                    {
                        crawler.y += 10 // This method will be executed once the timer is over
                    },
                    25 *(i+1).toLong() // value in milliseconds
                )
            }
            for (i in 30..50){
                Handler().postDelayed(
                    {
                        crawler.y -= 10 // This method will be executed once the timer is over
                    },
                    25 *(i+1).toLong() // value in milliseconds
                )
            }
            Handler().postDelayed(
                {
                     findViewById<View>(R.id.popup).visibility = View.VISIBLE// This method will be executed once the timer is over
                },
                1500 // value in milliseconds
            )
        }

        findViewById<View>(R.id.popup).setOnClickListener {
            findViewById<View>(R.id.popup).visibility = View.GONE
        }

        leftButton.setOnTouchListener(
            View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){
                MotionEvent.ACTION_DOWN -> {
                    if(crawler.x  > 0){
                        crawler.x -= 10
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if(crawler.x  > 0){
                        crawler.x -= 10
                    }
                    //view.performClick()
                }
                MotionEvent.ACTION_BUTTON_PRESS -> {
                    if(crawler.x  < 570){
                        crawler.x += 10
                    }
                }
            }
            return@OnTouchListener true
        })
        rightButton.setOnTouchListener(
            View.OnTouchListener { view, motionEvent ->
                when (motionEvent.action){
                    MotionEvent.ACTION_DOWN -> {
                        if(crawler.x  < 570){
                            crawler.x += 10
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        if(crawler.x  < 570){
                            crawler.x += 10
                        }
                    }
                    MotionEvent.ACTION_BUTTON_PRESS -> {
                        if(crawler.x  < 570){
                            crawler.x += 10
                        }


                    }
                }
                return@OnTouchListener true
            })


    }
}
