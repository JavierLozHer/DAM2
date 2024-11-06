package edu.iesam.dam2.features.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeroes()
    }
}