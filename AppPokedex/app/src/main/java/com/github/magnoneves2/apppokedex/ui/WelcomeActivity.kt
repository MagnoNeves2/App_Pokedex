package com.github.magnoneves2.apppokedex.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.magnoneves2.apppokedex.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val gif = findViewById<ImageView>(R.id.imgLoading)
        val mensagemRecebida = intent.getStringExtra("NOME")
        val nomeAventureiro = findViewById<TextView>(R.id.txtAdventureName)

        mensagemRecebida?.let{
            nomeAventureiro.text = mensagemRecebida
        }

        Glide.with(this)
            .load(R.drawable.img_loading)
            .asGif()
            .into(gif)

        GlobalScope.launch {
            delay(3000)
            this@WelcomeActivity.irParaQuartaTela()
        }
    }

    fun irParaQuartaTela() {
        val quartaTela = Intent(this, ListPokedexActivity::class.java)
        startActivity(quartaTela)
        finish()
    }
}