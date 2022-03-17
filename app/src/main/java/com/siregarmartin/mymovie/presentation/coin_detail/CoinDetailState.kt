package com.siregarmartin.mymovie.presentation.coin_detail

import com.siregarmartin.mymovie.domain.model.CoinDetail


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
