package com.mayokunadeniyi.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mayokunadeniyi.data.remote.response.Bank
import com.mayokunadeniyi.data.remote.response.Country
import com.mayokunadeniyi.data.common.utils.Constants.CARD_INFO_TABLE_NAME
import com.mayokunadeniyi.data.remote.response.DomainMapper
import com.mayokunadeniyi.domain.models.CardInfo

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

@Entity(tableName = CARD_INFO_TABLE_NAME)
data class CardInfoEntity(

    @ColumnInfo(name = "unique_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val bank: Bank?,
    val brand: String? = "",
    val country: Country?,
    val type: String? = ""
) : DomainMapper<CardInfo> {
    override fun mapToDomainModel() = CardInfo(
        bank = bank?.name ?: "",
        brand = brand ?: "",
        country = country?.name ?: "",
        type = type ?: ""
    )
}