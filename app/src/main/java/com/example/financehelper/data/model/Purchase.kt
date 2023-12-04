package com.example.financehelper.data.model

import com.example.financehelper.data.db.model.PurchaseEntity

data class Purchase(
    val id: Int,
    val purchaseName: String,
    val purchaseCost: Double,
    val walletId: Int,
) {
    fun toPurchaseEntity(): PurchaseEntity =
        PurchaseEntity(
            id, purchaseName, purchaseCost, walletId
        )
}