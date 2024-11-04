package edu.iesam.dam2.features.pokemon.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2.app.extensions.loadUrl
import edu.iesam.dam2.databinding.ViewPokemonItemBinding
import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewPokemonItemBinding

    fun bind(model: Pokemon) {
        binding = ViewPokemonItemBinding.bind(view)

        binding.apply {
            image.loadUrl(model.image)
            name.text = model.name
        }
    }

}