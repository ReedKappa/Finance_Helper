package com.example.financehelper.domain

import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface AddPurchaseUseCase {
    suspend operator fun invoke(id: Int, purchaseName: String, purchaseCost: Double): Result<Unit?>
}

class AddPurchaseUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
) : AddPurchaseUseCase {
    override suspend fun invoke(
        id: Int,
        purchaseName: String,
        purchaseCost: Double
    ): Result<Unit?> =
        repository.addPurchase(id, purchaseName, purchaseCost)

}