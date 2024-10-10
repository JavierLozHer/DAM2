package edu.iesam.dam2.features.superhero.presentation

import android.content.Context
import edu.iesam.dam2.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory(private val context: Context) {

    private val superHeroXmlLocalDataSource = SuperHeroXmlLocalDataSource(context)
    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroXmlLocalDataSource, superHeroMockRemoteDataSource)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun getSuperHeroListViewModel(): SuperHeroListViewModel {
        return SuperHeroListViewModel(getSuperHeroesUseCase)
    }

}