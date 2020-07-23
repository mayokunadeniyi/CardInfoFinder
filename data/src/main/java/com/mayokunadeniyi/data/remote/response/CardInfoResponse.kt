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
) : RoomMapper<CardInfoEntity> {
    override fun mapToRoomEntity(): CardInfoEntity =
        CardInfoEntity(bank = bank, brand = brand, country = country, type = type)
}

data class Bank(
    val name: String? = ""
)

data class Country(
    val name: String? = ""
)
