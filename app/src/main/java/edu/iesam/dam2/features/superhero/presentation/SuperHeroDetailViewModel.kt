package edu.iesam.dam2.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroDetailViewModel(private val getSuperHeroUseCase: GetSuperHeroUseCase): ViewModel() {

    fun viewCreated(superHeroId: String): SuperHero? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }

}