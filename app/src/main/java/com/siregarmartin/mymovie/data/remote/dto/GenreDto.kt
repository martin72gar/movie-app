package com.siregarmartin.mymovie.data.remote.dto

import com.siregarmartin.mymovie.domain.model.Genre

data class GenreDto(
    val genres: List<GenreResult>
)

fun GenreDto.toGenreResult(): List<GenreResult> {
    return genres
}