package com.github.magnoneves2.apppokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.magnoneves2.apppokedex.R
import com.github.magnoneves2.apppokedex.model.Pokemon


class ListPokedexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokedex)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val recyclerView = findViewById<RecyclerView>(R.id.rvListaPokemon)
        val dataset = ArrayList<Pokemon>()
        dataset.add(Pokemon(1, "bulbasaur"))
        dataset.add(Pokemon(10, "Teste"))
        dataset.add(Pokemon(100, "Teste"))

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(dataset)

    }
}