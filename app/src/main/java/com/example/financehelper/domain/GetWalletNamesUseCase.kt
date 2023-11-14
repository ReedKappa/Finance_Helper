package com.example.financehelper.domain

import com.example.financehelper.data.model.Wallet
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface GetWalletNamesUseCase {
    suspend operator fun invoke(): Result<List<Wallet>?>
}

class GetWalletNamesUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetWalletNamesUseCase {
    override suspend fun invoke(): Result<List<Wallet>?> =
        repository.getWalletNames()

}