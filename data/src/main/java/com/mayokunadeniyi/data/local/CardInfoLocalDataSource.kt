package com.mayokunadeniyi.data.local

import com.mayokunadeniyi.data.local.entities.CardInfoEntity
import com.mayokunadeniyi.domain.models.CardInfo

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

interface CardInfoLocalDataSource {

    suspend fun getCardInfo(): CardInfo

    suspend fun saveCardInfo(cardInfo: CardInfo)

    suspend fun deleteCardInfo()
}