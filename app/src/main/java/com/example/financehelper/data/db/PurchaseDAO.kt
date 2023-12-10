package com.example.financehelper.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.financehelper.data.db.model.PurchaseEntity
import com.example.financehelper.data.db.model.SalaryAndSpentEntity
import com.example.financehelper.data.db.model.WalletEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Dao
abstract class PurchaseDAO {

    @Upsert
    abstract suspend fun upsertPurchase(purchase: PurchaseEntity)

    @Query("SELECT * FROM purchases WHERE walletId=:walletId")
    abstract fun getPurchasesOrdered(walletId: Int): Flow<List<PurchaseEntity>>
}