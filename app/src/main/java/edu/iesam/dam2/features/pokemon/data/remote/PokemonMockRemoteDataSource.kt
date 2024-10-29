package edu.iesam.dam2.features.pokemon.data.remote

import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource {

    private val pokemons = listOf(
        Pokemon("1", "bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif"),
        Pokemon("2", "ivysaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/2.gif"),
        Pokemon("3", "venusaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/3.gif")
    )

    fun getPokemons(): List<Pokemon> {
        return pokemons
    }

    fun getPokemon(pokemonId: String): Pokemon? {
        return pokemons.firstOrNull{it.id == pokemonId}
    }
}