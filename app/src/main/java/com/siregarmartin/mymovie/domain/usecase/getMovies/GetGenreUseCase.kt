package com.siregarmartin.mymovie.domain.usecase.getMovies

import com.siregarmartin.mymovie.common.Resource
import com.siregarmartin.mymovie.data.remote.dto.GenreResult
import com.siregarmartin.mymovie.data.remote.dto.toGenreResult
import com.siregarmartin.mymovie.domain.model.Genre
import com.siregarmartin.mymovie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGenreUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<GenreResult>>> = flow {
        try {
            emit(Resource.Loading())
            val genre = repository.getGenre().toGenreResult()
            emit(Resource.Success(genre))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check internet connection"))
        }
    }
}