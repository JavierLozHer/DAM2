package edu.iesam.dam2.features.superhero.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHeroApiModel>>

    @GET("id/{superHeroId}.json")
    suspend fun requestSuperHero(@Path("superHeroId") superHeroId: String): Response<SuperHeroApiModel>
}