package com.example.financehelper.data.repository

import com.example.financehelper.data.db.PurchaseDAO
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.model.Wallet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface FinanceRepository {
    suspend fun getWalletNames(): Result<List<Wallet>?>
    suspend fun getSalary(): Result<Int?>
    fun purchaseOrdered(walletId: Int) :Flow<List<Purchase>>
    suspend fun upsertPurchase(purchase: Purchase)
    fun getCertainWalletSpendings(walletId: Int): Flow<List<Double>>
    val getAllSpendings: Flow<List<Double>>
}

class FinanceRepositoryImpl @Inject constructor(
    private val dao: PurchaseDAO,
) : FinanceRepository {

    override fun getCertainWalletSpendings(walletId: Int): Flow<List<Double>> =
        dao.getCertainWalletSpendings(walletId)

    override val getAllSpendings: Flow<List<Double>>
        get() = dao.getAllSpendings()


    override fun purchaseOrdered(walletId: Int) :Flow<List<Purchase>> {
        return dao.getPurchasesOrdered(walletId).map {
            it.map { it.toPurchase() }
        }
    }

    override suspend fun upsertPurchase(purchase: Purchase) {
        dao.upsertPurchase(purchase.toPurchaseEntity())
    }

    val salary = 80000


    override suspend fun getWalletNames(): Result<List<Wallet>?> {
        return Result.success(namesSource)
    }

    override suspend fun getSalary(): Result<Int?> {
        return Result.success(salary)
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