package edu.iesam.dam2.features.superhero.data.remote

import edu.iesam.dam2.app.domain.ErrorApp
import edu.iesam.dam2.features.superhero.domain.SuperHero


class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        // return apiCall(resourceService.requestResources())
        val result = superHeroService.requestSuperHeroes()
        if (result.isSuccessful) {
            val superHeroes = result.body()!!.map {
                it.toModel()
            }
            return Result.success(superHeroes)

        } else {
            return Result.failure(ErrorApp.ServerErrorApp)
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