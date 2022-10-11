package com.jerimkaura.litu.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jerimkaura.litu.data.remote.response.Promotion
import com.jerimkaura.litu.domain.usecase.promotionUseCase.PromotionsUseCase
import com.jerimkaura.litu.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val promotionsUseCase: PromotionsUseCase) :
    ViewModel() {
    var promotionList: List<Promotion> by mutableStateOf(listOf())
    private var promotionState = mutableStateOf(PromotionState())
    val _promotionState: State<PromotionState> = promotionState

    init {
        getPromotions()
    }

    private fun getPromotions() {
        promotionsUseCase().onEach { result ->
            when(result){
                is Resource.Success ->{
                    promotionState.value = PromotionState(data = result.data )
                    promotionList = promotionState.value.data!!.promotions
                }
                is Resource.Loading ->{
                    promotionState.value = PromotionState(isLoading = true)
                }

                is Resource.Error ->{
                    promotionState.value = result.error?.let { PromotionState(error = it) }!!
                }
            }
        }.launchIn(viewModelScope)
    }

}