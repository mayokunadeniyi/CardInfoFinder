package com.mayokunadeniyi.domain.repositories

import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

interface CardInfoRepository {
    suspend fun getCardInfo(cardNumber: Int, getFromRemote: Boolean): Result<CardInfo>
}