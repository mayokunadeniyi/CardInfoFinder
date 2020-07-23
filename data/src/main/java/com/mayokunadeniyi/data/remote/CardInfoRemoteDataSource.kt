package com.mayokunadeniyi.data.remote

import com.mayokunadeniyi.data.remote.response.CardInfoResponse
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

interface CardInfoRemoteDataSource {
    suspend fun getCardInfo(cardNumber: Double) : Result<CardInfo>
}