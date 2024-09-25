package edu.iesam.dam2.features.superhero.presentation

import edu.iesam.dam2.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) {

    fun viewCreated(): List<SuperHero> {
        return getSuperHeroesUseCase.invoke()
    }

    fun itemSelected(superHeroId: String) : SuperHero? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}