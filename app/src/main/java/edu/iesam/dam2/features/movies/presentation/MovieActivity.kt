package edu.iesam.dam2.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2.R
import edu.iesam.dam2.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val movieFactory: MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        bindData(movies)
        testXml()
    }

    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            movieSelect(movies, 0)
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            movieSelect(movies, 1)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            movieSelect(movies, 2)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            movieSelect(movies, 3)
        }
    }


    private fun movieSelect(movies: List<Movie>, movieNum: Int) {
        val movie: Movie? = viewModel.itemSelected(movies[movieNum].id)
        movie?.let {
            Log.d("@dev", "Pelicula seleccionada: ${it.title}")
        }
    }

    private fun testXml() {
        val xmlDataSource = MovieXmlLocalDataSource( this )
        val movie = viewModel.itemSelected("1")

        movie?.let {
            xmlDataSource.save(it)
        }

        val movieSaved = xmlDataSource.find()
        Log.d("@dev", movieSaved.toString())

        xmlDataSource.delete()
    }
}