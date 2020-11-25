package com.github.magnoneves2.apppokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.magnoneves2.apppokedex.R
import com.github.magnoneves2.apppokedex.adapter.PokemonAdapter
import com.github.magnoneves2.apppokedex.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient


class ListPokedexActivity : AppCompatActivity() {
    val recyclerView = findViewById<RecyclerView>(R.id.rvListaPokemon)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokedex)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN


        var dataset = ArrayList<Pokemon>()
        dataset.add(Pokemon(1, "bulbasaur"))
        dataset.add(Pokemon(10, "Teste"))
        dataset.add(Pokemon(100, "Teste"))




        CoroutineScope(IO).launch {
            requestPokemonApi()
        }

    }

    private suspend fun requestPokemonApi() {
        val dataset = getPokemonList()
        passDataToUI(dataset)
    }

    private suspend fun passDataToUI(pokemonList: ArrayList<Pokemon>) {
        withContext(Main) {
            delay(5000)
            initAdapter(pokemonList)
        }
    }

    private fun initAdapter(result: ArrayList<Pokemon>) {
        recyclerView.adapter = PokemonAdapter(result)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    private suspend fun getPokemonList(): ArrayList<Pokemon> {
        delay(1000)

        var pokemons: ArrayList<Pokemon> = ArrayList()
        var pokemonsApi = PokeApiClient()

        for(i in 0..20) {
            var pokemonData = pokemonsApi.getPokemon(i)
            val idPokemon = pokemonData.id
            val namePokemon = pokemonData.name
            pokemons.add(Pokemon(idPokemon, namePokemon))
        }

        return pokemons
    }
}