package com.siregarmartin.mymovie.domain.usecase.getMovies

import com.siregarmartin.mymovie.common.Resource
import com.siregarmartin.mymovie.data.remote.dto.toCoin
import com.siregarmartin.mymovie.data.remote.dto.toMovie
import com.siregarmartin.mymovie.domain.model.Coin
import com.siregarmartin.mymovie.domain.model.Movie
import com.siregarmartin.mymovie.domain.repository.CoinRepository
import com.siregarmartin.mymovie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(page: Int): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getPopularMovies(page).results.map { it.toMovie() }
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check internet connection"))
        }
    }
}