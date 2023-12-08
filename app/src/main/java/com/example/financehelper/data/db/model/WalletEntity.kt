package com.example.financehelper.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financehelper.data.model.Wallet

@Entity(tableName = "wallets")
data class WalletEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val walletName: String,
    val moneyLeft: Double,
    val percents: Float,
) {
    fun toWallet(): Wallet =
        Wallet(
            id, walletName, moneyLeft, percents
        )
}