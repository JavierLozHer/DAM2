package edu.iesam.dam2.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2.app.extensions.loadUrl
import edu.iesam.dam2.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2.features.movies.domain.Movie
import edu.iesam.dam2.features.superhero.domain.SuperHero

class MovieListFragment : Fragment() {

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!



    private lateinit var factory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = MovieFactory(requireContext())
        viewModel = factory.buildViewModel()
/*        factory = SuperHeroFactory(requireContext())
        viewModel = factory.getSuperHeroListViewModel()

        setupObserver()
        viewModel.loadSuperHeroes()
        */

        /*
        val movies = listOf(
            Movie("1", "title1", "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg",""),
            Movie("2", "title2", "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg", ""),
            Movie("3", "title3", "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg", ""))

            bindData(movies)

         */
    }

    private fun setupObserver() {
        /*
        val observer = Observer<SuperHeroListViewModel.UiState>{ uiState ->
            //codigo de respuesta
            uiState.superHeroes?.let { superHeroes ->
                bindData(superHeroes)
            }

            uiState.errorApp?.let {
                //pinto error
            } ?: run {
                //Ocultar error
            }

            if(uiState.isLoading) {
                //Muestro cargando
            } else {
                //Oculto cargando
            }

        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)

         */
    }

    private fun bindData(superHeroes: List<Movie>) {
        Log.d("@dev", superHeroes.toString())
        binding.apply {
            superhero1.apply {
                setOnClickListener {
                    navigateToDetails(superHeroes[0].id)
                }
            }

            imgSuperHero1.loadUrl(superHeroes[0].poster)
            textSuperHero1.text = superHeroes[0].title

            superhero2.apply {
                setOnClickListener{
                    navigateToDetails(superHeroes[1].id)
                }
            }

            imgSuperHero2.loadUrl(superHeroes[1].poster)
            textSuperHero2.text = superHeroes[1].title

            superhero3.apply {
                setOnClickListener{
                    navigateToDetails(superHeroes[2].id)
                }
            }

            imgSuperHero3.loadUrl(superHeroes[2].poster)
            textSuperHero3.text = superHeroes[2].title


        }

    }

    private fun navigateToDetails(superHeroId: String) {
        //findNavController().navigate(MovieListFragmentDirections.actionFromMovieToMovieDetail(superHeroId))
    }
}