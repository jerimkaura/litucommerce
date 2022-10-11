package com.jerimkaura.litu.domain.repository

import com.jerimkaura.litu.data.remote.LitudianAPI
import com.jerimkaura.litu.data.remote.response.PromotionsResponse
import javax.inject.Inject

class PromotionsRepository @Inject constructor(private val api: LitudianAPI) {
    suspend fun getPromotions(): PromotionsResponse = api.getPromotions()
}