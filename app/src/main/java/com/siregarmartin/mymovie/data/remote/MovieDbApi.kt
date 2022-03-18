package com.siregarmartin.mymovie.data.remote

import com.siregarmartin.mymovie.data.remote.dto.GenreDto
import com.siregarmartin.mymovie.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {

    @GET("/movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ): MovieDto

    @GET("/genre/movie/list")
    suspend fun getGenre(
        @Path("api_key") api_key: String,
    ): GenreDto
}