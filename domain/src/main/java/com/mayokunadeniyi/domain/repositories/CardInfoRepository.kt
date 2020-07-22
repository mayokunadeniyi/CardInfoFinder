package com.mayokunadeniyi.domain.repositories

import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

interface CardInfoRepository {
    fun getCardInfo(cardNumber: Double, getFromRemote: Boolean): Result<CardInfo>
}