package com.example.financehelper.domain

import com.example.financehelper.data.model.Wallet
import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetWalletsOrderedUseCase {
    operator fun invoke(): Flow<List<Wallet>>
}

class GetWalletsOrderedUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetWalletsOrderedUseCase {
    override fun invoke(): Flow<List<Wallet>> =
        repository.getWalletsOrdered

}