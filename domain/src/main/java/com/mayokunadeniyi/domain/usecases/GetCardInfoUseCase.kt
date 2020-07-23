package com.mayokunadeniyi.domain.usecases

import com.mayokunadeniyi.domain.base.BaseUseCase
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.repositories.CardInfoRepository
import com.mayokunadeniyi.domain.utils.Result
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

interface GetCardInfoUseCase : BaseUseCase<Double,CardInfo> {
     override suspend operator fun invoke(param: Double): Result<CardInfo>
}