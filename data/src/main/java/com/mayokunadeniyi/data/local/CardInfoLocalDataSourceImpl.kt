package com.mayokunadeniyi.data.local

import com.mayokunadeniyi.data.local.dao.CardInfoDao
import com.mayokunadeniyi.data.mapper.CardInfoMapperLocal
import com.mayokunadeniyi.domain.models.CardInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class CardInfoLocalDataSourceImpl (
    private val cardInfoDao: CardInfoDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): CardInfoLocalDataSource{
    val mapper = CardInfoMapperLocal()
    override suspend fun getCardInfo(): CardInfo = withContext(ioDispatcher){
        return@withContext mapper.transform(cardInfoDao.getCardInfo())
    }

    override suspend fun saveCardInfo(cardInfo: CardInfo) = withContext(ioDispatcher){
        val mapper = CardInfoMapperLocal()
        cardInfoDao.saveCardInfo(mapper.transformToRepository(cardInfo))
    }

    override suspend fun deleteCardInfo() = withContext(ioDispatcher){
        cardInfoDao.deleteAllCardInfo()
    }
}