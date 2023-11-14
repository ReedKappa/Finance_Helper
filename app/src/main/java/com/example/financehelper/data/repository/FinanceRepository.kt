package com.example.financehelper.data.repository

import com.example.financehelper.data.model.Wallet
import javax.inject.Inject

interface FinanceRepository {
    suspend fun getWalletNames() : Result<List<Wallet>?>
    suspend fun getSalary() : Result<Int?>
}

class FinanceRepositoryImpl @Inject constructor(
): FinanceRepository {

    val salary = 80000

    val namesSource = listOf<Wallet>(
            Wallet(
                walletName = "Неотложенные расходы",
                moneyLeft = 0,
                percents = 0.5f
            ),
            Wallet(
                walletName = "Благосостояние",
                moneyLeft = 0,
                percents = 0.1f
            ),
            Wallet(
                walletName = "Развлечения",
                moneyLeft = 0,
                percents = 0.1f
            ),
            Wallet(
                walletName = "Образование",
                moneyLeft = 0,
                percents = 0.1f
            ),
            Wallet(
                walletName = "Свободные расходы",
                moneyLeft = 0,
                percents = 0.1f
            ),
        )

    override suspend fun getWalletNames(): Result<List<Wallet>?> {
        return Result.success(namesSource)
    }

    override suspend fun getSalary(): Result<Int?> {
        return Result.success(salary)
    }

}