package com.mayokunadeniyi.data.remote.api

import com.mayokunadeniyi.data.remote.response.CardInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

interface CardInfoApiService {

    @GET("/{cardNumber}")
    suspend fun getCardInfo(@Path("cardNumber")cardNumber: Double): Response<CardInfoResponse>

}