package com.mayokunadeniyi.data.repositories

import com.mayokunadeniyi.data.local.entities.CardInfoEntity
import com.mayokunadeniyi.data.remote.response.Bank
import com.mayokunadeniyi.data.remote.response.CardInfoResponse
import com.mayokunadeniyi.data.remote.response.Country

/**
 * Created by Mayokun Adeniyi on 24/07/2020.
 */

const val CARD_NUMBER = 123456
val fakeCardInfoEntity = CardInfoEntity(
    bank = Bank("adf"),
    type = "Type",
    brand = "Brand",
    country = Country("Country")
)
val successCardInfoResponse = CardInfoResponse(
    bank = Bank("adf"),
    type = "Type",
    brand = "Brand",
    country = Country("Country")
)