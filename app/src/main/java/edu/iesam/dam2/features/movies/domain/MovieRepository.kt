package edu.iesam.dam2.features.movies.domain

interface MovieRepository {

    fun getMovies():List<Movie>
    fun getMovie(movieId: String): Movie?

}