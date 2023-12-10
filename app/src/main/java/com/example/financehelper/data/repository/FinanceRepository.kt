package com.example.financehelper.data.repository

import com.example.financehelper.R
import com.example.financehelper.data.db.PurchaseDAO
import com.example.financehelper.data.db.SalaryDAO
import com.example.financehelper.data.db.WalletDAO
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.di.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface FinanceRepository {
    fun purchaseOrdered(walletId: Int) :Flow<List<Purchase>>
    suspend fun upsertPurchase(purchase: Purchase)
    suspend fun upsertWallet(wallet: Wallet)
    suspend fun upsertSalary(salaryAndSpent: SalaryAndSpent)
    suspend fun changeMoneyValues(purchase: Purchase, wallet: Wallet, salaryAndSpent: SalaryAndSpent)
    val getSalary: Flow<SalaryAndSpent>
    val getWalletsOrdered: Flow<List<Wallet>>
    suspend fun isOnboardingRequired(): Flow<Boolean>
    suspend fun getAllWallets(): List<Wallet>
    suspend fun getCertainWallet(walletId: Int): Wallet
    suspend fun getSalary(): SalaryAndSpent
}

class FinanceRepositoryImpl @Inject constructor(
    private val purchaseDAO: PurchaseDAO,
    private val walletDAO: WalletDAO,
    private val salaryDAO: SalaryDAO,
) : FinanceRepository {

    override val getSalary: Flow<SalaryAndSpent>
        get() = salaryDAO.getSalaryFlow().map {
            it.toSalaryAndSpent()
        }

    override val getWalletsOrdered: Flow<List<Wallet>>
        get() = walletDAO.getAllWalletsOrdered().map {
            it.map { it.toWallet() }
        }

    override suspend fun isOnboardingRequired(): Flow<Boolean> {
        return salaryDAO.getSalaryFlow().map {
            it == null
        }
    }

    override suspend fun getAllWallets(): List<Wallet> =
        walletDAO.getAllWallets().map {
            it.toWallet()
        }

    override suspend fun getCertainWallet(walletId: Int): Wallet =
        walletDAO.getCertainWallet(walletId).toWallet()

    override suspend fun getSalary(): SalaryAndSpent =
        salaryDAO.getSalary().toSalaryAndSpent()

    override fun purchaseOrdered(walletId: Int) :Flow<List<Purchase>> {
        return purchaseDAO.getPurchasesOrdered(walletId).map {
            it.map { it.toPurchase() }
        }
    }

    override suspend fun upsertPurchase(purchase: Purchase) {
        purchaseDAO.upsertPurchase(purchase.toPurchaseEntity())
    }

    override suspend fun upsertWallet(wallet: Wallet) {
        walletDAO.upsertWallet(wallet.toWalletEntity())
    }

    override suspend fun upsertSalary(salaryAndSpent: SalaryAndSpent) {
        salaryDAO.upsertSalary(salaryAndSpent.toSalaryAndSpentEntity())
    }

    override suspend fun changeMoneyValues(
        purchase: Purchase,
        wallet: Wallet,
        salaryAndSpent: SalaryAndSpent
    ) {
        val purchaseCost = purchase.purchaseCost
        val walletMoneyLeft = wallet.moneyLeft
        val salaryMoneySpent = salaryAndSpent.moneySpent
        upsertPurchase(purchase)
        walletDAO.upsertWallet(wallet.toWalletEntity().copy(moneyLeft = walletMoneyLeft - purchaseCost))
        salaryDAO.upsertSalary(salaryAndSpent.toSalaryAndSpentEntity().copy(moneySpent = salaryMoneySpent + purchaseCost))
    }

}