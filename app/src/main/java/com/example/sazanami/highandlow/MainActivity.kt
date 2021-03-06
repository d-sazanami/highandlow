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
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answered = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.hightBtn.setOnClickListener{
            if ((gameStart && !answered)) {
                highAndLow('h')
            }
        }

        binding.lowBtn.setOnClickListener {
            if ((gameStart && !answered)) {
                highAndLow('l')
            }
        }

        binding.nextBtn.setOnClickListener{
            if (gameStart) {
                drawCard()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0

        binding.hitText.text = getString(R.string.hit_text)
        binding.loseText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard()
    }

    private fun drawCard() {
        binding.yourCardImage.setImageResource(R.drawable.bk0)
        binding.droidCardImage.setImageResource(R.drawable.bk0)

        yourCard = (1..13).random()
        Log.d(tag, "You: " + yourCard)
        when(yourCard) {
            1 -> binding.yourCardImage.setImageResource(R.drawable.c01)
            2 -> binding.yourCardImage.setImageResource(R.drawable.c02)
            3 -> binding.yourCardImage.setImageResource(R.drawable.c03)
            4 -> binding.yourCardImage.setImageResource(R.drawable.c04)
            5 -> binding.yourCardImage.setImageResource(R.drawable.c05)
            6 -> binding.yourCardImage.setImageResource(R.drawable.c06)
            7 -> binding.yourCardImage.setImageResource(R.drawable.c07)
            8 -> binding.yourCardImage.setImageResource(R.drawable.c08)
            9 -> binding.yourCardImage.setImageResource(R.drawable.c09)
            10 -> binding.yourCardImage.setImageResource(R.drawable.c10)
            11 -> binding.yourCardImage.setImageResource(R.drawable.c11)
            12 -> binding.yourCardImage.setImageResource(R.drawable.c12)
            13 -> binding.yourCardImage.setImageResource(R.drawable.c13)
        }

        droidCard = (1..13).random()
        Log.d(tag, "droid : " + droidCard)
        answered = false
    }

    private fun highAndLow(answer:Char) {
        showDroidCard()
        answered = true
        val balance = droidCard - yourCard
        if (balance == 0) {
        } else if ((balance > 0 && answer == 'h')) {
            hitCount++
            binding.hitText.text = getString(R.string.hit_text) + hitCount
        } else if ((balance < 0 && answer == 'l')) {
            hitCount++
            binding.hitText.text = getString(R.string.hit_text) + hitCount
        } else {
            loseCount++
            binding.loseText.text = getString(R.string.lose_text)  + loseCount
        }

        if (hitCount == 5) {
            binding.resultText.text = "????????????????????????"
            gameStart = false
        } else if (loseCount == 5) {
            binding.resultText.text = "????????????????????????"
            gameStart = false
        } else {
        }
    }

    private fun showDroidCard() {
        when (droidCard) {
            1 -> binding.droidCardImage.setImageResource(R.drawable.c01)
            2 -> binding.droidCardImage.setImageResource(R.drawable.c02)
            3 -> binding.droidCardImage.setImageResource(R.drawable.c03)
            4 -> binding.droidCardImage.setImageResource(R.drawable.c04)
            5 -> binding.droidCardImage.setImageResource(R.drawable.c05)
            6 -> binding.droidCardImage.setImageResource(R.drawable.c06)
            7 -> binding.droidCardImage.setImageResource(R.drawable.c07)
            8 -> binding.droidCardImage.setImageResource(R.drawable.c08)
            9 -> binding.droidCardImage.setImageResource(R.drawable.c09)
            10 -> binding.droidCardImage.setImageResource(R.drawable.c10)
            11 -> binding.droidCardImage.setImageResource(R.drawable.c11)
            12 -> binding.droidCardImage.setImageResource(R.drawable.c12)
            13 -> binding.droidCardImage.setImageResource(R.drawable.c13)
        }
    }
}