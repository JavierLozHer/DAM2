package edu.iesam.dam2.features.movies.presentation

import edu.iesam.dam2.features.movies.data.MovieDataRepository
import edu.iesam.dam2.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2.features.movies.domain.GetMoviesUseCase

class MovieFactory {

    private val movieMockRemoteDataSource = MovieMockRemoteDataSource()
    private val movieDataRepository = MovieDataRepository(movieMockRemoteDataSource)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel( getMoviesUseCase, getMovieUseCase )
    }

}