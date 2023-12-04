package com.example.financehelper.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.financehelper.data.db.model.PurchaseEntity

@Database(
    entities = [
        PurchaseEntity::class
    ],
    version = 1
)
abstract class PurchaseDataBase: RoomDatabase() {
    abstract val purchaseDAO: PurchaseDAO
}