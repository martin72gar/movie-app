package com.siregarmartin.mymovie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)
