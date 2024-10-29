package edu.iesam.dam2.features.pokemon.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.dam2.R
import edu.iesam.dam2.app.extensions.loadUrl
import edu.iesam.dam2.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2.features.movies.domain.Movie
import edu.iesam.dam2.features.movies.presentation.MovieDetailActivity
import edu.iesam.dam2.features.movies.presentation.MovieDetailViewModel
import edu.iesam.dam2.features.movies.presentation.MovieFactory
import edu.iesam.dam2.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
       getMovieId()?.let {
           bindData(PokemonMockRemoteDataSource().getPokemon(it)!!)
       }


    }
/*
    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro cargando
                Log.d("@dev", "Cargando...")
            } else {
                //oculto cargando
            }
        }
        viewModel.uiState.observe(this, movieObserver)
    }

 */

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    private fun bindData(movie: Pokemon) {
        val imageView = findViewById<ImageView>(R.id.poster)
        imageView.loadUrl(movie.image)
        val textView = findViewById<TextView>(R.id.title)
        textView.text = movie.name

        val imageType1 = findViewById<ImageView>(R.id.type1)
        imageType1.loadUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/types/generation-viii/brilliant-diamond-and-shining-pearl/12.png")

        val imageType2 = findViewById<ImageView>(R.id.type2)
        imageType2.loadUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/types/generation-viii/brilliant-diamond-and-shining-pearl/4.png")

    }

    companion object{
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, PokemonDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}