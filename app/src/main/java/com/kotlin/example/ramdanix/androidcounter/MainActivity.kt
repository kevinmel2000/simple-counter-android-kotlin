package com.kotlin.example.ramdanix.androidcounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var scoreLeft : Int = 0;
    private var scoreRight : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initOnClickListener()
    }

    fun initOnClickListener(){
        btnFreeThrow.setOnClickListener(clickListener)
        btnFreeThrowRight.setOnClickListener(clickListener)
        btnPlus2.setOnClickListener(clickListener)
        btnPlus2Right.setOnClickListener(clickListener)
        btnPlus3.setOnClickListener(clickListener)
        btnPlus3Right.setOnClickListener(clickListener)
        btnReset.setOnClickListener(clickListener)
    }

    //
    val clickListener = View.OnClickListener { view ->  when(view.id){
            R.id.btnPlus3 -> 3.tambahScoreA()
            R.id.btnPlus3Right -> 3.tambahScoreB()
            R.id.btnPlus2 -> 2.tambahScoreA()
            R.id.btnPlus2Right -> 2.tambahScoreB()
            R.id.btnFreeThrow -> 1.tambahScoreA()
            R.id.btnFreeThrowRight -> 1.tambahScoreB()
            R.id.btnReset -> reset()
        }
    }

    fun reset(){
        scoreLeft = 0
        scoreRight = 0
        scoreLeft.updateViewScoreA()
        scoreRight.updateViewScoreB()
    }

    //use Extension Functions
    fun Int.tambahScoreA(){
        scoreLeft += this
        scoreLeft.updateViewScoreA()
    }

    //use Extension Functions
    fun Int.tambahScoreB(){
        scoreRight += this
        scoreRight.updateViewScoreB()
    }

    //use Extension Functions
    fun Int.updateViewScoreA(){
        tvScoreLeft.text = this.toString()
    }

    //use Extension Functions
    fun Int.updateViewScoreB(){
        tvScoreRight.text = this.toString()
    }

}
