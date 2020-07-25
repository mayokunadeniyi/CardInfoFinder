package com.mayokunadeniyi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mayokunadeniyi.data.local.entities.CardInfoEntity

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

@Dao
interface CardInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCardInfo(cardInfo: CardInfoEntity)

    @Query("SELECT * FROM card_info_table WHERE unique_id=:id LIMIT 1")
    suspend fun getCardInfo(id: Int): CardInfoEntity?

    @Query("DELETE FROM card_info_table")
    suspend fun deleteAllCardInfo()

}