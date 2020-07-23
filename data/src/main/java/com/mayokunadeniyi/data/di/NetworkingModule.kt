package com.mayokunadeniyi.data.di

import com.mayokunadeniyi.data.BuildConfig
import com.mayokunadeniyi.data.common.utils.Constants.BASE_URL
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
    single { GsonConverterFactory.create() as Converter.Factory }
    single {HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) as Interceptor}
    single {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(interceptor = get())
                .callTimeout(10, TimeUnit.SECONDS)
        }.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addCallAdapterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(CardInfoApiService::class.java) }
}