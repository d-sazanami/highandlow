package com.example.sazanami.highandlow

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.sazanami.highandlow.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0

        hitText.text = getString(R.string.hit_text)
        loseText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard()
    }

    private fun drawCard() {
        yourCardImage.setImageResource(R.drawable.bk0)
        droidCardImage.setImageResource(R.drawable.bk0)

        yourCard = (1..13).random()
        Log.d(tag, "You: " + yourCard)
        when(yourCard) {
            1 -> yourCardImage.setImageResource(R.drawable.c01)
            2 -> yourCardImage.setImageResource(R.drawable.c02)
            3 -> yourCardImage.setImageResource(R.drawable.c03)
            4 -> yourCardImage.setImageResource(R.drawable.c04)
            5 -> yourCardImage.setImageResource(R.drawable.c05)
            6 -> yourCardImage.setImageResource(R.drawable.c06)
            7 -> yourCardImage.setImageResource(R.drawable.c07)
            8 -> yourCardImage.setImageResource(R.drawable.c08)
            9 -> yourCardImage.setImageResource(R.drawable.c09)
            10 -> yourCardImage.setImageResource(R.drawable.c10)
            11 -> yourCardImage.setImageResource(R.drawable.c11)
            12 -> yourCardImage.setImageResource(R.drawable.c12)
            13 -> yourCardImage.setImageResource(R.drawable.c13)
        }

        droidCard = (1..13).random()
        Log.d(tag, "droid : " + droidCard)
        answered = false
    }
}