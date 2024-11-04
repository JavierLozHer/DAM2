package edu.iesam.dam2.features.pokemon.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2.R
import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonAdapter : RecyclerView.Adapter<PokemonViewHolder>() {

    private val dataList : MutableList<Pokemon> = mutableListOf()

    fun setDataList(pokemons: List<Pokemon>) {
        dataList.clear()
        dataList.addAll(pokemons)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}