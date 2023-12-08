package com.example.financehelper.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.financehelper.data.db.model.PurchaseEntity
import com.example.financehelper.data.db.model.SalaryAndSpentEntity
import com.example.financehelper.data.db.model.WalletEntity

@Database(
    entities = [
        PurchaseEntity::class,
        WalletEntity::class,
        SalaryAndSpentEntity::class,
    ],
    version = 1
)
abstract class PurchaseDataBase: RoomDatabase() {
    abstract val purchaseDAO: PurchaseDAO
    abstract val salaryDAO: SalaryDAO
    abstract val WalletDAO: WalletDAO
}