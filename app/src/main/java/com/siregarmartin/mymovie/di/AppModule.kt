package com.siregarmartin.mymovie.di

import com.siregarmartin.mymovie.common.Constants
import com.siregarmartin.mymovie.data.remote.CoinPaprikaApi
import com.siregarmartin.mymovie.data.remote.MovieDbApi
import com.siregarmartin.mymovie.data.repository.CoinRepositoryImpl
import com.siregarmartin.mymovie.data.repository.MovieRepositoryImpl
import com.siregarmartin.mymovie.domain.repository.CoinRepository
import com.siregarmartin.mymovie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideMovieDbApi(): MovieDbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieDbApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}
