package com.github.magnoneves2.apppokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.github.magnoneves2.apppokedex.R
import com.github.magnoneves2.apppokedex.adapter.AbasAdapter
import com.github.magnoneves2.apppokedex.fragments.AbilitiesFragment
import com.github.magnoneves2.apppokedex.fragments.EvolutionFragment
import com.github.magnoneves2.apppokedex.fragments.StatsFragment
import com.google.android.material.tabs.TabLayout

class PokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        //Referenciando as Views
        val abas = findViewById<TabLayout>(R.id.abas)
        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        //Instanciamos o adapter e inserimos as fragments que queremos exibir e seus titulos(abas)
        val adapter = AbasAdapter(supportFragmentManager)
        adapter.add(StatsFragment(), "Estatísticas")
        adapter.add(EvolutionFragment(), "Evoluções")
        adapter.add(AbilitiesFragment(), "Habilidades")

        //Vinculamos o adapter criado ao adapter da ViewPager
        viewPager.adapter = adapter

        //Vinculamos a ViewPager ao nosso Tablayout
        abas.setupWithViewPager(viewPager)

    }
}