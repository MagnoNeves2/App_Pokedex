package com.github.magnoneves2.apppokedex.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.github.magnoneves2.apppokedex.R
import com.github.magnoneves2.apppokedex.model.Pokemon

//Responsável por vincular os dados (dataset) ao meu item (layout)
class PokemonAdapter(
    private val dataset: ArrayList<Pokemon>
): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    //Classe de ViewHolder
    //Reponsável por referenciar os ids dos componentes
    //Do layout item que criamos
    class PokemonViewHolder(val itemPokemon: CardView) : RecyclerView.ViewHolder(itemPokemon)

    //Método responsável por inflar/mostrar/visualizar o layout/xml do item que criamos
    //Retornando o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false) as CardView

        return PokemonViewHolder(cardView)
    }

    //Vincula os dados aos componentes do meu item
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {

        val nomePokemon = holder.itemPokemon.findViewById<TextView>(R.id.txtNomePokemon)
        val idPokemon = holder.itemPokemon.findViewById<TextView>(R.id.txtIdPokemon)

        nomePokemon.text = dataset[position].nome
        idPokemon.text = mascaraId(dataset[position].id)
    }

    //Devolve a quantidade de itens no meu dataset
    override fun getItemCount(): Int {
        return dataset.size
    }

    private fun mascaraId(id: Int): String {
        return if(id < 9) {
            "#00$id"
        } else if(id in 10..99) {
            "#0$id"
        } else {
            "#$id"
        }
    }

}