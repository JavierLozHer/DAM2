package edu.iesam.dam2.features.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2.databinding.FragmentSuperheroDetailBinding

class SuperHeroDetailFragment: Fragment() {

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    private val superHeroArgs: SuperHeroDetailFragmentArgs by navArgs()

    private lateinit var viewModel: SuperHeroDetailViewModel
    private lateinit var factory : SuperHeroFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        factory = SuperHeroFactory(requireContext())
        viewModel = factory.getSuperHeroDetailViewModel()
        super.onViewCreated(view, savedInstanceState)

        superHeroArgs.superHeroId
    }

    private fun setupObserver() {
        val observer = Observer<SuperHeroDetailViewModel.UiState> { uiState ->

        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }
}