package com.example.financehelper.data.model

data class Wallet(
    val walletId: Int,
    val walletName: String,
    val moneyLeft: Int,
    val percents: Float,
    val purchaseList: MutableList<Purchase>
): Finance