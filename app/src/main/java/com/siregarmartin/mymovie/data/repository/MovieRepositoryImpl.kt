package com.siregarmartin.mymovie.data.repository

import com.siregarmartin.mymovie.data.remote.TheMovieApi
import com.siregarmartin.mymovie.data.remote.dto.MovieResult
import com.siregarmartin.mymovie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TheMovieApi
) : MovieRepository {
    override suspend fun getCoins(): List<MovieResult> {
        return api.getPopularMovie()
    }
}