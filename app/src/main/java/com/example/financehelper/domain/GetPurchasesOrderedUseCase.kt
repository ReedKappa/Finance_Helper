package com.example.financehelper.domain

import com.example.financehelper.data.model.Purchase
import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPurchasesOrderedUseCase {
    operator fun invoke(walletId: Int):Flow<List<Purchase>>
}

class GetPurchasesOrderedUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetPurchasesOrderedUseCase {
    override fun invoke(walletId: Int): Flow<List<Purchase>> =
        repository.purchaseOrdered(walletId)

}