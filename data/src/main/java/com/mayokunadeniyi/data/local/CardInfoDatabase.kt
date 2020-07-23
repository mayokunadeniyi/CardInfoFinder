package com.mayokunadeniyi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mayokunadeniyi.data.local.dao.CardInfoDao
import com.mayokunadeniyi.data.local.entities.CardInfoEntity

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

@Database(entities = [CardInfoEntity::class],version = 1,exportSchema = false)
abstract class CardInfoDatabase : RoomDatabase(){

    abstract val cardInfoDao: CardInfoDao
}