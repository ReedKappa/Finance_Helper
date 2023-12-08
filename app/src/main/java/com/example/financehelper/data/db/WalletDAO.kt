package com.example.financehelper.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.financehelper.data.db.model.WalletEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WalletDAO {
    @Upsert
    suspend fun upsertWallet(wallet: WalletEntity)

    @Query("SELECT * FROM wallets")
    fun getAllWalletsOrdered(): Flow<List<WalletEntity>>
}