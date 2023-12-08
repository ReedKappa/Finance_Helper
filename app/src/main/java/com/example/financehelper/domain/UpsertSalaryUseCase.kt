package com.example.financehelper.domain

import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UpsertSalaryUseCase {
    suspend operator fun invoke(salaryAndSpent: SalaryAndSpent)
}

class UpsertSalaryUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): UpsertSalaryUseCase {
    override suspend fun invoke(salaryAndSpent: SalaryAndSpent) =
        repository.upsertSalary(salaryAndSpent)

}