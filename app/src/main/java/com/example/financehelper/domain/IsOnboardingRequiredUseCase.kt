package com.example.financehelper.domain

import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IsOnboardingRequiredUseCase {
    suspend operator fun invoke(): Flow<Boolean>
}

class IsOnboardingRequiredUSeCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): IsOnboardingRequiredUseCase {
    override suspend fun invoke(): Flow<Boolean> =
        repository.isOnboardingRequired()

}