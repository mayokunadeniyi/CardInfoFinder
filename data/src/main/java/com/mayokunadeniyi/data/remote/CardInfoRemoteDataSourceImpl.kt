package com.mayokunadeniyi.data.remote

import com.mayokunadeniyi.data.mapper.CardInfoMapperRemote
import com.mayokunadeniyi.data.remote.api.CardInfoApiService
import com.mayokunadeniyi.data.remote.response.CardInfoResponse
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class CardInfoRemoteDataSourceImpl (
    private val api: CardInfoApiService = CardInfoApi.retrofitService ,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): CardInfoRemoteDataSource{
    private val mapper: CardInfoMapperRemote = CardInfoMapperRemote()
    override suspend fun getCardInfo(cardNumber: Double): Result<CardInfo> = withContext(ioDispatcher){
        return@withContext try {
            val result = api.getCardInfo(cardNumber)
            if (result.isSuccessful){
                val cardResponse = result.body()?.let { mapper.transform(it) }
                Result.Success(cardResponse)
            }else{
                Result.Error(Exception("Bad request/response"))
            }
        }catch (exception: Exception){
            Result.Error(exception)
        }
    }
}