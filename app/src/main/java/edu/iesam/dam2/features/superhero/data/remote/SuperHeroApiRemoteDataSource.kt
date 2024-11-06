package edu.iesam.dam2.features.superhero.data.remote

import edu.iesam.dam2.features.superhero.domain.SuperHero
import org.koin.core.annotation.Single

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero> {
        val result = superHeroService.requestSuperHeroes()
        if (result.isSuccessful) {
            return result.body()!!.map {
                it.toModel()
            }
        } else {
            return emptyList()
        }
    }

    suspend fun getSuperHero(superHeroId: String): SuperHero {
        val result = superHeroService.requestSuperHero(superHeroId)
        if (result.isSuccessful) {
            return result.body()!!.toModel()
        } else {
            return SuperHero("error", "error", "error")
        }
    }
}