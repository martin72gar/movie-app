package com.siregarmartin.mymovie.presentation.ui.movie

import com.siregarmartin.mymovie.data.remote.dto.GenreResult

data class GenreListState(
    val isLoading: Boolean = false,
    val genres: List<GenreResult> = emptyList(),
    val error: String = ""
)
