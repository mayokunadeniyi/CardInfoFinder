package com.mayokunadeniyi.data.di

import com.mayokunadeniyi.data.BuildConfig
import com.mayokunadeniyi.data.utils.Constants.BASE_URL
import com.mayokunadeniyi.data.remote.api.CardInfoApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

val networkingModule = module {

    single<CardInfoApiService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CardInfoApiService::class.java)
    }

    single<OkHttpClient> {

        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        httpClient
    }
}