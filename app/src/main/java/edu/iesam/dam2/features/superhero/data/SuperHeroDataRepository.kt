package edu.iesam.dam2.features.superhero.data

import edu.iesam.dam2.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroDataRepository(private val superHeroMockRemoteDataSource: SuperHeroMockRemoteDataSource) {

    fun getSuperHeroes(): List<SuperHero> {
        return superHeroMockRemoteDataSource.getSuperHeroes()
    }
}