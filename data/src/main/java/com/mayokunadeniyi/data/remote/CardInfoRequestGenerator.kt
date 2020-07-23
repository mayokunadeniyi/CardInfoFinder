package com.mayokunadeniyi.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mayokunadeniyi.data.remote.api.CardInfoApiService
import com.mayokunadeniyi.data.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()


object CardInfoApi {
    val retrofitService: CardInfoApiService by lazy {
        retrofit.create(
            CardInfoApiService::class.java
        )
    }
}