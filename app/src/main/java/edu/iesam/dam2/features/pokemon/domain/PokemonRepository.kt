package edu.iesam.dam2.features.pokemon.domain

interface PokemonRepository {

    fun getPokemons(): List<Pokemon>
    fun getPokemon(pokemonId: String): Pokemon?
}