package com.example.financehelper.domain

import com.example.financehelper.data.model.Wallet
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface GetCertainWalletUseCase {
    suspend operator fun invoke(walletId: Int): Wallet
}

class GetCertainWalletUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetCertainWalletUseCase {
    override suspend fun invoke(walletId: Int): Wallet =
        repository.getCertainWallet(walletId)

}