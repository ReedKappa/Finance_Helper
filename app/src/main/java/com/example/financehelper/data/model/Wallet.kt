package com.example.financehelper.data.model

import com.example.financehelper.data.db.model.WalletEntity

data class Wallet(
    val id: Int,
    val walletName: String,
    val moneyLeft: Double,
    val percents: Float,
): Finance {
    fun toWalletEntity(): WalletEntity =
        WalletEntity(
            id, walletName, moneyLeft, percents
        )
}