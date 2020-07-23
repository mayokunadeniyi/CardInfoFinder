package com.mayokunadeniyi.data.repositories

import com.mayokunadeniyi.data.local.CardInfoLocalDataSource
import com.mayokunadeniyi.data.remote.CardInfoRemoteDataSource
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.repositories.CardInfoRepository
import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class CardInfoRepositoryImpl(
    private val localDataSource: CardInfoLocalDataSource,
    private val remoteDataSource: CardInfoRemoteDataSource
): CardInfoRepository{
    override suspend fun getCardInfo(cardNumber: Double, getFromRemote: Boolean): Result<CardInfo> {
        return if (getFromRemote){
            val result = remoteDataSource.getCardInfo(cardNumber)
            if (result is Result.Success){
                localDataSource.saveCardInfo(result.data!!)
            }
            result
        }else{
            Result.Success(localDataSource.getCardInfo())
        }
    }

}