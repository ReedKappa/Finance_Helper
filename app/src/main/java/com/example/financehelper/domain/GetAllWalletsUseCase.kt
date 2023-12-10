package com.example.financehelper.domain

import com.example.financehelper.data.model.Wallet
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface GetAllWalletsUseCase {
    suspend operator fun invoke(): List<Wallet>
}

class GetAllWalletsUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository,
): GetAllWalletsUseCase {
    override suspend fun invoke(): List<Wallet> =
        repository.getAllWallets()

}