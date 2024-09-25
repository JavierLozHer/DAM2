package edu.iesam.dam2.features.movies.data

import edu.iesam.dam2.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2.features.movies.domain.Movie
import edu.iesam.dam2.features.movies.domain.MovieRepository

class MovieDataRepository (private val mockRemoteDataSource: MovieMockRemoteDataSource) : MovieRepository {

    override fun getMovies(): List<Movie>{
        return mockRemoteDataSource.getMovies()
    }

    override fun getMovie(movieId: String): Movie? {
        return mockRemoteDataSource.getMovie(movieId)
    }

}
