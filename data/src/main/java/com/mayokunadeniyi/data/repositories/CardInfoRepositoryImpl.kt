package com.mayokunadeniyi.data.repositories

import com.mayokunadeniyi.data.local.dao.CardInfoDao
import com.mayokunadeniyi.data.local.entities.CardInfoEntity
import com.mayokunadeniyi.data.mapper.CardInfoMapperLocal
import com.mayokunadeniyi.data.mapper.CardInfoMapperRemote
import com.mayokunadeniyi.data.remote.api.CardInfoApiService
import com.mayokunadeniyi.data.remote.response.toEntity
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.repositories.CardInfoRepository
import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class CardInfoRepositoryImpl(
    private val cardInfoApi: CardInfoApiService,
    private val cardInfoDao: CardInfoDao
) : CardInfoRepository {

    override suspend fun getCardInfo(cardNumber: Int, getFromRemote: Boolean): Result<CardInfo> {
        return when {
            getFromRemote -> {
                val cardInfoResult = cardInfoApi.getCardInfo(cardNumber)
                if (cardInfoResult.isSuccessful) {
                    val mapperRemote = CardInfoMapperRemote()
                    val remoteData = cardInfoResult.body()
                    if (remoteData != null) {
                        cardInfoDao.saveCardInfo(
                            CardInfoEntity(
                                id = cardNumber,
                                bank = remoteData.bank,
                                brand = remoteData.brand,
                                country = remoteData.country,
                                type = remoteData.type
                            )
                        )
                        Result.Success(mapperRemote.transform(remoteData))
                    } else {
                        Result.Success(null)
                    }
                } else {
                    Result.Error(Exception("Invalid data/failure"))
                }
            }
            else -> {
                val localData = cardInfoDao.getCardInfo(cardNumber)
                if (localData == null) {
                    Result.Success(null)
                } else {
                    val mapperLocal = CardInfoMapperLocal()
                    Result.Success(mapperLocal.transform(localData))
                }
            }
        }
    }
}