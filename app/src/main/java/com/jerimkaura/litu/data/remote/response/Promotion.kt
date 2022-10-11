package com.jerimkaura.litu.data.remote.response


import com.google.gson.annotations.SerializedName

data class Promotion(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)