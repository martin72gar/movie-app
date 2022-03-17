package com.siregarmartin.mymovie.domain.repository

import com.siregarmartin.mymovie.data.remote.dto.CoinDetailDto
import com.siregarmartin.mymovie.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}