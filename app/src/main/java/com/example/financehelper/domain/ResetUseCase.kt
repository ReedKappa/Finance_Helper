package com.example.financehelper.domain

import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface ResetUseCase {
    suspend operator fun invoke()
}

class ResetUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): ResetUseCase {
    override suspend fun invoke() =
        repository.clear()

}