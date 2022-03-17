package com.siregarmartin.mymovie.domain.repository

import com.siregarmartin.mymovie.data.remote.dto.MovieResult
import retrofit2.http.GET

interface MovieRepository {

    @GET("/movie/popular")
    suspend fun getCoins(): List<MovieResult>
}