package com.example.financehelper.data.repository

import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.model.Wallet
import javax.inject.Inject

interface FinanceRepository {
    suspend fun getWalletNames() : Result<List<Wallet>?>
    suspend fun getSalary() : Result<Int?>

    suspend fun addPurchase(id: Int, purchaseName: String, purchaseCost: Double): Result<Unit?>
}

class FinanceRepositoryImpl @Inject constructor(
): FinanceRepository {

    val salary = 80000

    val namesSource = listOf<Wallet>(
            Wallet(
                walletId = 1,
                walletName = "Неотложенные расходы",
                moneyLeft = 0,
                percents = 0.5f,
                purchaseList = mutableListOf()
            ),
            Wallet(
                walletId = 2,
                walletName = "Благосостояние",
                moneyLeft = 0,
                percents = 0.1f,
                purchaseList = mutableListOf()
            ),
            Wallet(
                walletId = 3,
                walletName = "Развлечения",
                moneyLeft = 0,
                percents = 0.1f,
                purchaseList = mutableListOf()
            ),
            Wallet(
                walletId = 4,
                walletName = "Образование",
                moneyLeft = 0,
                percents = 0.1f,
                purchaseList = mutableListOf()
            ),
            Wallet(
                walletId = 5    ,
                walletName = "Свободные расходы",
                moneyLeft = 0,
                percents = 0.1f,
                purchaseList = mutableListOf()
            ),
        )

    override suspend fun getWalletNames(): Result<List<Wallet>?> {
        return Result.success(namesSource)
    }

    override suspend fun getSalary(): Result<Int?> {
        return Result.success(salary)
    }

    override suspend fun addPurchase(
        id: Int,
        purchaseName: String,
        purchaseCost: Double
    ): Result<Unit?> {
        val currentList = namesSource.first() {
            it.walletId == id
        }.purchaseList
        currentList.add(Purchase(purchaseName, purchaseCost))
        return Result.success(Unit)
    }


}