package edu.iesam.dam2.features.superhero.domain

interface SuperHeroRepository {

    fun getSuperHeroes() : List<SuperHero>
    fun getSuperHero(superHeroId: String): SuperHero?
}