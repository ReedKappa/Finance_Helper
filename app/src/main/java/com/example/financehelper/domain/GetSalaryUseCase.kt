package com.example.financehelper.domain

import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface GetSalaryUseCase {
    suspend operator fun invoke(): Result<Int?>
}

class GetSalaryUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetSalaryUseCase {
    override suspend fun invoke(): Result<Int?> =
        repository.getSalary()
}