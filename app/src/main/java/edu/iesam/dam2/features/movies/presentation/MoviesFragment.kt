package edu.iesam.dam2.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2.R
import edu.iesam.dam2.app.domain.ErrorApp
import edu.iesam.dam2.app.extensions.loadUrl
import edu.iesam.dam2.databinding.FragmentMoviesBinding
import edu.iesam.dam2.features.movies.domain.Movie


class MoviesFragment: Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("@dev", "moviesFragment")
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()
    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun bindData(movies: List<Movie>) {
        binding.apply {
            superhero1.apply {
                setOnClickListener {
                    navigateToMovieDetail(movies[0].id)
                }
            }

            imgSuperHero1.loadUrl(movies[0].poster)
            textSuperHero1.text = movies[0].title

            superhero2.apply {
                setOnClickListener{
                    navigateToMovieDetail(movies[1].id)
                }
            }

            imgSuperHero2.loadUrl(movies[1].poster)
            textSuperHero2.text = movies[1].title

            superhero3.apply {
                setOnClickListener{
                    navigateToMovieDetail(movies[2].id)
                }
            }

            imgSuperHero3.loadUrl(movies[2].poster)
            textSuperHero3.text = movies[2].title


        }
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
        startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}


