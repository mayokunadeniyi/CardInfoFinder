package com.mayokunadeniyi.data.di

import androidx.room.Room
import com.mayokunadeniyi.data.common.utils.Constants.CARD_INFO_DB
import com.mayokunadeniyi.data.local.CardInfoDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), CardInfoDatabase::class.java, CARD_INFO_DB)
            .fallbackToDestructiveMigration().build()
    }

    factory { get<CardInfoDatabase>().cardInfoDao }
}