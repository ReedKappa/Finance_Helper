package com.example.financehelper.domain

import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface GetPurchasesUseCase {
    suspend operator fun invoke(id: Int): Result<MutableList<Purchase>?>
}

class GetPurchasesUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetPurchasesUseCase {
    override suspend fun invoke(id: Int): Result<MutableList<Purchase>?> =
        repository.getPurchases(id)

}