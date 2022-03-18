package com.siregarmartin.mymovie.data.repository

import com.siregarmartin.mymovie.common.Constants
import com.siregarmartin.mymovie.data.remote.MovieDbApi
import com.siregarmartin.mymovie.data.remote.dto.GenreDto
import com.siregarmartin.mymovie.data.remote.dto.MovieDto
import com.siregarmartin.mymovie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieDbApi
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): MovieDto {
        return api.getPopularMovie(api_key = Constants.API_KEY_MOVIE, page = page)
    }

    override suspend fun getGenre(): GenreDto {
        return api.getGenre(api_key = Constants.API_KEY_MOVIE)
    }
}