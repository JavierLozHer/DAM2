package edu.iesam.dam2.features.movies.data.local

import android.content.Context
import edu.iesam.dam2.R
import edu.iesam.dam2.features.movies.domain.Movie

class MovieXmlLocalDataSource (private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE)

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

    fun delete(){
        sharedPref.edit().clear().apply()
    }

}