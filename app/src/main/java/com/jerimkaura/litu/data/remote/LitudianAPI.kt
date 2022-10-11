package com.jerimkaura.litu.data.remote

import com.jerimkaura.litu.data.remote.response.PromotionsResponse
import retrofit2.http.GET

interface LitudianAPI {
    companion object {
        const val GET_PROMOTIONS = "DRXF"
    }

    @GET(GET_PROMOTIONS)
    suspend fun getPromotions(): PromotionsResponse
}
