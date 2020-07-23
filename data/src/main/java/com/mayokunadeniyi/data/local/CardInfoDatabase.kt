package com.mayokunadeniyi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mayokunadeniyi.data.local.dao.CardInfoDao
import com.mayokunadeniyi.data.local.entities.CardInfoEntity
import com.mayokunadeniyi.data.local.typeconverter.Converters

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

@Database(entities = [CardInfoEntity::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class CardInfoDatabase : RoomDatabase(){

    abstract val cardInfoDao: CardInfoDao
}