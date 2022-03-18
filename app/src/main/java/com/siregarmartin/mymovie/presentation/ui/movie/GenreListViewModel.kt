package com.siregarmartin.mymovie.presentation.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siregarmartin.mymovie.common.Resource
import com.siregarmartin.mymovie.domain.model.Genre
import com.siregarmartin.mymovie.domain.usecase.getMovies.GetGenreUseCase
import com.siregarmartin.mymovie.presentation.coin_list.CoinListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

class GenreListViewModel @Inject constructor(
    private val getGenreUseCase: GetGenreUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(GenreListState())
    val state: State<GenreListState> = _state

    init {
        getGenres()
    }

    private fun getGenres() {
        val response = getGenreUseCase.invoke()
        response.onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = GenreListState(genres = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = GenreListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = GenreListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}