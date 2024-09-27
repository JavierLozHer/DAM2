package edu.iesam.dam2.features.movies.data.remote

import edu.iesam.dam2.features.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies = listOf(
    Movie("1", "title1", "poster1"),
    Movie("2", "title2", "poster2"),
    Movie("3", "title3", "poster3"),
    Movie(title = "title4", poster = "poster4", id = "4")
    )
    fun getMovies(): List<Movie>{
        return movies
    }

    fun getMovie(id: String) : Movie? {
        return movies.firstOrNull{ it.id == id}
    }
}