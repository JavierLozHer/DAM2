package edu.iesam.dam2.features.superhero.presentation

import edu.iesam.dam2.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory {


    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroMockRemoteDataSource)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)


    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel( getSuperHeroesUseCase, getSuperHeroUseCase)
    }

}