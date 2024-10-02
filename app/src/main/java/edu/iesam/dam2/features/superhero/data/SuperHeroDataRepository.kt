package edu.iesam.dam2.features.superhero.data

import edu.iesam.dam2.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2.features.superhero.domain.SuperHero
import edu.iesam.dam2.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val localXml: SuperHeroXmlLocalDataSource,
    private val mockRemoteDataSource: SuperHeroMockRemoteDataSource
) : SuperHeroRepository {

    override fun getSuperHeroes(): List<SuperHero> {
        val superHeroFromLocal = localXml.findAll()
        if (superHeroFromLocal.isEmpty()) {
            val superHeroFromRemote = mockRemoteDataSource.getSuperHeroes()
            localXml.saveAll(superHeroFromRemote)
            return superHeroFromRemote
        } else {
            return superHeroFromLocal
        }

    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        val localSuperHero = localXml.findById(superHeroId)
        if (localSuperHero != null) {
            mockRemoteDataSource.getSuperHero(superHeroId)?.let {
                localXml.save(it)
                return it
            }
        }
        return localSuperHero
    }
}