package edu.iesam.dam2.features.superhero.presentation

import edu.iesam.dam2.features.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroViewModel(private val getSuperHeroesUseCase: GetSuperHeroesUseCase) {

    fun viewCreated(): List<SuperHero> {
        return getSuperHeroesUseCase.invoke()
    }
}