package com.mayokunadeniyi.domain.di

import com.mayokunadeniyi.domain.usecases.GetCardInfoUseCase
import com.mayokunadeniyi.domain.usecases.GetCardInfoUseCaseImpl
import org.koin.dsl.module

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

val interactionModule = module {
    factory<GetCardInfoUseCase> { GetCardInfoUseCaseImpl(get()) }
}