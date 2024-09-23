package edu.iesam.dam2.features.superhero.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeroes()
    }
}