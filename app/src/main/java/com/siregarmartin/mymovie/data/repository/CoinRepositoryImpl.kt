package com.siregarmartin.mymovie.data.repository

import com.siregarmartin.mymovie.data.remote.CoinPaprikaApi
import com.siregarmartin.mymovie.data.remote.dto.CoinDetailDto
import com.siregarmartin.mymovie.data.remote.dto.CoinDto
import com.siregarmartin.mymovie.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}