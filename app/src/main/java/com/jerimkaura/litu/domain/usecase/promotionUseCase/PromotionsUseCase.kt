package com.jerimkaura.litu.domain.usecase.promotionUseCase

import android.util.Log
import androidx.compose.ui.layout.VerticalAlignmentLine
import com.jerimkaura.litu.data.remote.response.PromotionsResponse
import com.jerimkaura.litu.domain.repository.PromotionsRepository
import com.jerimkaura.litu.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PromotionsUseCase @Inject constructor(private val repository: PromotionsRepository) {
    operator fun invoke(): Flow<Resource<PromotionsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getPromotions()
            emit(Resource.Success(response))
        }catch(e: IOException){
            emit(Resource.Error("Check internet connection"))
        }catch (e: HttpException){
            emit(Resource.Error("An error occurred"))
        }
    }
}