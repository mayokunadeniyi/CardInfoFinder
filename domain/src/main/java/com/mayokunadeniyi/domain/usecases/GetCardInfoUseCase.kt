package com.mayokunadeniyi.domain.usecases

import com.mayokunadeniyi.domain.repositories.CardInfoRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class GetCardInfoUseCase : KoinComponent {
     private val cardInfoRepository: CardInfoRepository by inject()
     operator fun invoke(cardNumber: Double, getFromRemote: Boolean) = cardInfoRepository.getCardInfo(cardNumber,getFromRemote)
}