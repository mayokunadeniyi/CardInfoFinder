package com.mayokunadeniyi.data.remote.response

import com.mayokunadeniyi.data.local.entities.CardInfoEntity


/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

data class CardInfoResponse(
    val bank: Bank?,
    val brand: String? = "",
    val country: Country?,
    val type: String? = ""
)

data class Bank(
    val name: String? = ""
)

data class Country(
    val name: String? = ""
)

/**
 * This helps to convert [CardInfoResponse] to [CardInfoEntity]
 */
fun CardInfoResponse.toEntity() =
    CardInfoEntity(bank = bank, country = country, type = type, brand = brand)