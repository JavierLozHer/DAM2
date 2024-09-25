package edu.iesam.dam2.features.superhero.data.remote

import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroMockRemoteDataSource {

    private val superHeroes = listOf(
        SuperHero("1", "A-Bomb", "1-a-bomb"),
        SuperHero("2", "Abe Sapien", "2-abe-sapien"),
        SuperHero("3", "Abin Sur", "3-abin-sur")
    )
    fun getSuperHeroes(): List<SuperHero> {
        return superHeroes
    }

    fun getSuperHero(superHeroId: String): SuperHero? {
        return superHeroes.firstOrNull{ it.id == superHeroId }
    }

}