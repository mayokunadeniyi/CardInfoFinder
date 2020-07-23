package com.mayokunadeniyi.data.local.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mayokunadeniyi.data.remote.response.Bank
import com.mayokunadeniyi.data.remote.response.Country
import java.lang.reflect.Type

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

class Converters {
    val gson = Gson()

    val type: Type = object : TypeToken<Bank?>() {}.type

    @TypeConverter
    fun fromBank(bank: Bank?): String{
        return gson.toJson(bank,type)
    }

    @TypeConverter
    fun toBank(json: String?): Bank {
        return gson.fromJson(json,type)
    }

    @TypeConverter
    fun fromCountry(country: Country?): String{
        return gson.toJson(country,type)
    }

    @TypeConverter
    fun toCountry(json: String?): Country {
        return gson.fromJson(json,type)
    }
}