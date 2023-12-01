package com.example.financehelper.data.repository

import android.util.Log
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.model.Wallet
import javax.inject.Inject
import javax.inject.Singleton

interface FinanceRepository {
    suspend fun getWalletNames(): Result<List<Wallet>?>
    suspend fun getSalary(): Result<Int?>

    suspend fun addPurchase(id: Int, purchaseName: String, purchaseCost: Double): Result<Unit?>

    suspend fun getPurchases(id: Int): Result<MutableList<Purchase>?>
}

class FinanceRepositoryImpl @Inject constructor(
) : FinanceRepository {

    val salary = 80000


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
        val wallet = namesSource.first {
            it.walletId == id
        }
        val currentList = wallet.purchaseList
        currentList.add(Purchase(purchaseName, purchaseCost))
        return Result.success(Unit)
    }

    override suspend fun getPurchases(id: Int): Result<MutableList<Purchase>?> {
        val wallet = namesSource.first() {
            it.walletId == id
        }
        val currentList = wallet.purchaseList
        Log.d(this::class.simpleName, wallet.toString())
        Log.d(this::class.simpleName, currentList.toString())
        return Result.success(currentList)
    }

    companion object {
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
                walletId = 5,
                walletName = "Свободные расходы",
                moneyLeft = 0,
                percents = 0.1f,
                purchaseList = mutableListOf()
            ),
        )
    }

}