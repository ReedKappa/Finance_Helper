package com.example.financehelper.domain

import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.repository.FinanceRepository
import javax.inject.Inject

interface GetSalaryUseCase {
    suspend operator fun invoke(): SalaryAndSpent
}

class GetSalaryUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository,
): GetSalaryUseCase {
    override suspend fun invoke(): SalaryAndSpent =
        repository.getSalary()

}