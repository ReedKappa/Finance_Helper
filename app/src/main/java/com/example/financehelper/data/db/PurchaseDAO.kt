package com.example.financehelper.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.financehelper.data.db.model.PurchaseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDAO {
    @Upsert
    suspend fun upsertPurchase(purchase: PurchaseEntity)

    @Query("SELECT * FROM purchases WHERE walletId=:walletId")
    fun getPurchasesOrdered(walletId: Int): Flow<List<PurchaseEntity>>

    @Query("SELECT purchaseCost FROM purchases WHERE walletId=:walletId")
    fun getCertainWalletSpendings(walletId: Int): Flow<List<Double>>

    @Query("SELECT purchaseCost FROM purchases")
    fun getAllSpendings(): Flow<List<Double>>
}