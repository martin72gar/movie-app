package com.siregarmartin.mymovie.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val rating: Double,
    val releaseDate: String
)