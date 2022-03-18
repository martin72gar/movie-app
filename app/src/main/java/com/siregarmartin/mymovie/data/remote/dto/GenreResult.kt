package com.siregarmartin.mymovie.data.remote.dto

import com.siregarmartin.mymovie.domain.model.Genre

data class GenreResult(
    val id: Int,
    val name: String
)

fun GenreResult.toGenre(): Genre {
    return Genre(genre = name)
}