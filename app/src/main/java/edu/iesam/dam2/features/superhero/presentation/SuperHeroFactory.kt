package edu.iesam.dam2.features.superhero.presentation

import android.content.Context
import edu.iesam.dam2.app.data.api.ApiClient
import edu.iesam.dam2.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory(private val context: Context) {

    private val superHeroXmlLocalDataSource = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroXmlLocalDataSource, getSuperHeroApiRemoteDataSource())
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun getSuperHeroListViewModel(): SuperHeroListViewModel {
        return SuperHeroListViewModel(getSuperHeroesUseCase)
    }

    private fun getSuperHeroApiRemoteDataSource(): SuperHeroApiRemoteDataSource {
        val superHeroService = ApiClient.provideSuperHeroService()
        return SuperHeroApiRemoteDataSource(superHeroService)
    }

    fun getSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }

}