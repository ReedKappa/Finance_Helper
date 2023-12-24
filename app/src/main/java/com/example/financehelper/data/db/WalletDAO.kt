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

    @Query("SELECT * FROM wallets")
    suspend fun getAllWallets(): List<WalletEntity>

    @Query("SELECT * FROM wallets WHERE id=:walletId")
    suspend fun getCertainWallet(walletId: Int) : WalletEntity

    @Query("DELETE FROM wallets WHERE 1=1")
    suspend fun clear()
}