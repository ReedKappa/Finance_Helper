package com.example.financehelper.domain

import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface ChangeMoneyValuesUseCase {
    suspend operator fun invoke(purchase: Purchase, wallet: Wallet, salaryAndSpent: SalaryAndSpent)
}

class ChangeMoneyValuesUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): ChangeMoneyValuesUseCase {
    override suspend fun invoke(
        purchase: Purchase,
        wallet: Wallet,
        salaryAndSpent: SalaryAndSpent
    ) =
        repository.changeMoneyValues(purchase, wallet, salaryAndSpent)
}