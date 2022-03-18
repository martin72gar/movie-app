package com.siregarmartin.mymovie.domain.repository

import com.siregarmartin.mymovie.data.remote.dto.GenreDto
import com.siregarmartin.mymovie.data.remote.dto.MovieDto
import com.siregarmartin.mymovie.data.remote.dto.MovieResult
import retrofit2.http.GET

interface MovieRepository {

    suspend fun getPopularMovies(page: Int): MovieDto

    suspend fun getGenre() : GenreDto
}