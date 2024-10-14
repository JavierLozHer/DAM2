package edu.iesam.dam2.features.pokemon.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2.R
import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml_pokemon), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun save(pokemon: Pokemon) {
        val editor = sharedPref.edit()
        editor.putString(pokemon.id, gson.toJson(pokemon))
        editor.apply()
    }

    fun saveAll(pokemons: List<Pokemon>) {
        val editor = sharedPref.edit()
        pokemons.forEach{pokemon ->
            editor.putString(pokemon.id, gson.toJson(pokemon))
        }
        editor.apply()
    }

    fun findById(pokemonId: String) : Pokemon? {
        return sharedPref.getString(pokemonId, null)?.let { pokemon ->
            gson.fromJson(pokemon, Pokemon::class.java)
        }
    }


}