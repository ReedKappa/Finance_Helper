package com.example.financehelper.domain

import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetCertainWalletSpendingsUseCase {
    operator fun invoke(walletId: Int): Flow<List<Double>>
}

class GetCertainWalletSPendingsUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetCertainWalletSpendingsUseCase {
    override fun invoke(walletId: Int): Flow<List<Double>> =
        repository.getCertainWalletSpendings(walletId)
}