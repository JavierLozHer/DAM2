package edu.iesam.dam2.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2.app.domain.ErrorApp
import edu.iesam.dam2.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2.features.superhero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(private val getSuperHeroUseCase: GetSuperHeroUseCase) : ViewModel() {

    private val _uiSate = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiSate

    fun loadSuperHero(superHeroId: String) {
        _uiSate.postValue(UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val superHero = getSuperHeroUseCase.invoke(superHeroId)
            _uiSate.postValue(UiState(superHero = superHero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHero: SuperHero? = null
    )
}