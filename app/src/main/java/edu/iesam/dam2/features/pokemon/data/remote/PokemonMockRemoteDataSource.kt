package edu.iesam.dam2.features.pokemon.data.remote

import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource {

    private val pokemons = listOf(
        Pokemon("1", "bulbasaur", ""),
        Pokemon("2", "charmander", ""),
        Pokemon("1", "squirtle", "")
    )

    fun getPokemons(): List<Pokemon> {
        return pokemons
    }

    fun getPokemon(pokemonId: String): Pokemon? {
        return pokemons.firstOrNull{it.id == pokemonId}
    }
}