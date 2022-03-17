package com.siregarmartin.mymovie.data.remote

import com.siregarmartin.mymovie.data.remote.dto.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ): Response<MovieResponse>
}