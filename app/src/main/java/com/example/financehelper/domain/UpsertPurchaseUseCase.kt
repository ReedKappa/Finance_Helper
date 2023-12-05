package com.example.financehelper.domain

import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface UpsertPurchaseUseCase {
    suspend operator fun invoke(purchase: Purchase)
}

class UpsertPurchaseUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): UpsertPurchaseUseCase {
    override suspend fun invoke(purchase: Purchase) =
        repository.upsertPurchase(purchase)

}