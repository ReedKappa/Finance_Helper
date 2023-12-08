package com.example.financehelper.data.repository

import com.example.financehelper.data.db.PurchaseDAO
import com.example.financehelper.data.db.SalaryDAO
import com.example.financehelper.data.db.WalletDAO
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.model.Wallet
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
        purchaseDAO.changeMoneyValues(purchase.toPurchaseEntity(), wallet.toWalletEntity(), salaryAndSpent.toSalaryAndSpentEntity())
    }

    companion object {
        val namesSource = listOf<Wallet>(
            Wallet(
                id = 1,
                walletName = "Неотложенные расходы",
                moneyLeft = 0.0,
                percents = 0.5f,
            ),
            Wallet(
                id = 2,
                walletName = "Благосостояние",
                moneyLeft = 0.0,
                percents = 0.1f,
            ),
            Wallet(
                id = 3,
                walletName = "Развлечения",
                moneyLeft = 0.0,
                percents = 0.1f,
            ),
            Wallet(
                id = 4,
                walletName = "Образование",
                moneyLeft = 0.0,
                percents = 0.1f,
            ),
            Wallet(
                id = 5,
                walletName = "Свободные расходы",
                moneyLeft = 0.0,
                percents = 0.1f,
            ),
        )
    }

}