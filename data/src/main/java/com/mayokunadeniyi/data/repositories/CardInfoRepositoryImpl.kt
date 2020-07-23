package com.mayokunadeniyi.data.repositories

import com.mayokunadeniyi.data.local.dao.CardInfoDao
import com.mayokunadeniyi.data.local.entities.CardInfoEntity
import com.mayokunadeniyi.data.remote.api.CardInfoApiService
import com.mayokunadeniyi.data.remote.response.getData
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.repositories.CardInfoRepository
import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class CardInfoRepositoryImpl(
    private val cardInfoApi: CardInfoApiService,
    private val cardInfoDao: CardInfoDao
) : BaseRepository<CardInfo, CardInfoEntity>(), CardInfoRepository {
    override suspend fun getCardInfo(cardNumber: Double): Result<CardInfo> {
        return fetchData(
            apiDataProvider = {
                cardInfoApi.getCardInfo(cardNumber).getData(
                    fetchFromCacheAction = { cardInfoDao.getCardInfo() },
                    cacheAction = { cardInfoDao.saveCardInfo(it) }
                )
            },
            dbDataProvider = { cardInfoDao.getCardInfo() }
        )
    }
}