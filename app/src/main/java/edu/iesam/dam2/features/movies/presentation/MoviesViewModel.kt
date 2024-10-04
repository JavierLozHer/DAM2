package edu.iesam.dam2.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2.app.domain.ErrorApp
import edu.iesam.dam2.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoviesViewModel (
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated() {
        _uiState.postValue(UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()
            delay(5000)

            //postValue origen: Default, IO, Main   Destino: Main
            //value origen/destino: Mismo
            _uiState.postValue(UiState(movies = movies))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movies : List<Movie>? = null
    )

}