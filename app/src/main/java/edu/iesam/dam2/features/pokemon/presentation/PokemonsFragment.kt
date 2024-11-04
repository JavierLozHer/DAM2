package edu.iesam.dam2.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2.app.domain.ErrorApp
import edu.iesam.dam2.app.extensions.loadUrl
import edu.iesam.dam2.databinding.FragmentMoviesBinding
import edu.iesam.dam2.databinding.FragmentPokemonsListBinding
import edu.iesam.dam2.features.movies.domain.Movie
import edu.iesam.dam2.features.movies.presentation.MovieDetailActivity
import edu.iesam.dam2.features.movies.presentation.MovieFactory
import edu.iesam.dam2.features.movies.presentation.MoviesViewModel
import edu.iesam.dam2.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2.features.pokemon.domain.Pokemon

class PokemonsFragment: Fragment() {


    private var _binding: FragmentPokemonsListBinding? = null
    private val binding get() = _binding!!

    private val pokemonAdapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            list.layoutManager = LinearLayoutManager (
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            list.adapter = pokemonAdapter
        }
        bind()
//        bindData(PokemonMockRemoteDataSource().getPokemons())
    }

    private fun bind() {
        pokemonAdapter.setDataList(PokemonMockRemoteDataSource().getPokemons())
    }

    private fun setupObserver() {
        /*
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

         */
    }

    private fun bindData(movies: List<Pokemon>) {
        /*
        binding.apply {
            superhero1.apply {
                setOnClickListener {
                    navigateToMovieDetail(movies[0].id)
                }
            }

            imgSuperHero1.loadUrl(movies[0].image)
            textSuperHero1.text = movies[0].name

            superhero2.apply {
                setOnClickListener{
                    navigateToMovieDetail(movies[1].id)
                }
            }

            imgSuperHero2.loadUrl(movies[1].image)
            textSuperHero2.text = movies[1].name

            superhero3.apply {
                setOnClickListener{
                    navigateToMovieDetail(movies[2].id)
                }
            }

            imgSuperHero3.loadUrl(movies[2].image)
            textSuperHero3.text = movies[2].name


        }

         */
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
        //startActivity(PokemonDetailActivity.getIntent(requireContext(), movieId))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}