package com.jerimkaura.litu.ui.screens.home

import com.jerimkaura.litu.data.remote.response.PromotionsResponse

class PromotionState (
    var isLoading:Boolean = false,
    var data: PromotionsResponse? = null,
    var error: String = ""
)