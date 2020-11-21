package com.github.magnoneves2.apppokedex.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.magnoneves2.apppokedex.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        GlobalScope.launch {
            delay(2500)
            this@SplashScreenActivity.irSegundaTela()
        }
    }

    private fun irSegundaTela() {
        val segundaTela = Intent(this, InsertNameActivity::class.java)
        startActivity(segundaTela)
        finish()
    }
}