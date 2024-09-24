package edu.iesam.dam2.features.movies.presentation

import edu.iesam.dam2.features.movies.data.MovieDataRepository
import edu.iesam.dam2.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2.features.movies.domain.GetMoviesUseCase

class MovieFactory {

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel( GetMoviesUseCase( MovieDataRepository( MovieMockRemoteDataSource() ) ),  GetMovieUseCase( MovieDataRepository( MovieMockRemoteDataSource() ) ) )
    }

}