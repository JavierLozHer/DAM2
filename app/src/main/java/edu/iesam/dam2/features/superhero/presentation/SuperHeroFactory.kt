package edu.iesam.dam2.features.superhero.presentation

import edu.iesam.dam2.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory {

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel( GetSuperHeroesUseCase( SuperHeroDataRepository( SuperHeroMockRemoteDataSource())))
    }
}