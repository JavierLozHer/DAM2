package edu.iesam.dam2.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2.R
import edu.iesam.dam2.features.movies.domain.Movie

class MovieXmlLocalDataSource (private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun save(movie: Movie) {
        /*
        val editor = sharedPref.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
        */
        sharedPref.edit().apply{
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
            apply()
        }
    }

    fun find(): Movie{
        sharedPref.apply {
            return Movie(
                getString("id", "")!!,
                getString("title", "")!!,
                getString("poster", "")!!
            )
        }
    }


    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun findAll(): List<Movie> {
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all // as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun find(movieId: String): Movie? {
        val movie: Movie? = null
        val mapMovies = sharedPref.all // as Map<String, String>
        mapMovies.values.firstNotNullOf { jsonMovie ->
            val movieA = gson.fromJson(jsonMovie as String, Movie::class.java)
            movieA.id ==movieId
        }
        return movie
    }


    fun delete(){
        sharedPref.edit().clear().apply()
    }
}