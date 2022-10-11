package com.jerimkaura.litu.data.remote.response


import com.google.gson.annotations.SerializedName

data class PromotionsResponse(
    @SerializedName("promotions")
    val promotions: List<Promotion>
)