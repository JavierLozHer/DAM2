package edu.iesam.dam2.features.movies.data

import edu.iesam.dam2.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2.features.movies.domain.Movie
import edu.iesam.dam2.features.movies.domain.MovieRepository

class MovieDataRepository (
    private val localXml: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) : MovieRepository {

    override fun getMovies(): List<Movie>{
        val movieFromLocal = localXml.findAll()
        if (movieFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            localXml.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return movieFromLocal
        }
    }

    override fun getMovie(movieId: String): Movie? {
        val movieFromLocal = localXml.find()
        if (movieFromLocal.id != movieId) {
            val movieFromRemote = mockRemoteDataSource.getMovie(movieId)
            movieFromRemote?.let { localXml.save(it) }
            return movieFromRemote
        } else {
            return movieFromLocal
        }
    }

}
