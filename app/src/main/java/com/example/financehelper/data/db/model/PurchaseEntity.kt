package com.example.financehelper.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financehelper.data.model.Purchase

@Entity(tableName = "purchases")
data class PurchaseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val purchaseName: String,
    val purchaseCost: Double,
    val walletId: Int,
) {
    fun toPurchase(): Purchase =
        Purchase(
            id, purchaseName, purchaseCost, walletId
        )
}