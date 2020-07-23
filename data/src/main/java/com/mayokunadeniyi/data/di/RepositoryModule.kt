package com.mayokunadeniyi.data.di

import com.mayokunadeniyi.data.common.utils.Connectivity
import com.mayokunadeniyi.data.common.utils.ConnectivityImpl
import com.mayokunadeniyi.data.repositories.CardInfoRepositoryImpl
import com.mayokunadeniyi.domain.repositories.CardInfoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

val repositoryModule = module {
    factory<CardInfoRepository> { CardInfoRepositoryImpl(get(), get()) }
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}