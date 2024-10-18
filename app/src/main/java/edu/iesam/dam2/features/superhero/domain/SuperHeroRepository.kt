package edu.iesam.dam2.features.superhero.domain

interface SuperHeroRepository {

    suspend fun getSuperHeroes() : List<SuperHero>
    suspend fun getSuperHero(superHeroId: String): SuperHero?
}