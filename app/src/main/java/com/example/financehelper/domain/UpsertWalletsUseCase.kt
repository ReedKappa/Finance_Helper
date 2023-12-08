package com.example.financehelper.domain

import com.example.financehelper.data.model.Wallet
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface UpsertWalletsUseCase {
    suspend operator fun invoke(wallet: Wallet)
}

class UpsertWalletsUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): UpsertWalletsUseCase {
    override suspend fun invoke(wallet: Wallet) =
        repository.upsertWallet(wallet)

}