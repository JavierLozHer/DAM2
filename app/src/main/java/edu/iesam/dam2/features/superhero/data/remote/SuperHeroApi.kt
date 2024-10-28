package edu.iesam.dam2.features.superhero.data.remote

data class SuperHeroApiModel(val id: String, val name: String, val images: SuperHeroImageApiModel)
data class SuperHeroImageApiModel(val md: String)