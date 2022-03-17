package com.siregarmartin.mymovie.domain.usecase.get_coins

import com.siregarmartin.mymovie.common.Resource
import com.siregarmartin.mymovie.data.remote.dto.toCoin
import com.siregarmartin.mymovie.data.remote.dto.toCoinDetail
import com.siregarmartin.mymovie.domain.model.Coin
import com.siregarmartin.mymovie.domain.model.CoinDetail
import com.siregarmartin.mymovie.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coindId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coindId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check internet connection"))
        }
    }
}