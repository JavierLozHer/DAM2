package edu.iesam.dam2.features.pokemon.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke(pokemonId: String): Pokemon? {
        return pokemonRepository.getPokemon(pokemonId)
    }
}