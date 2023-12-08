package com.example.financehelper.domain

import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetSalaryUseCase {
    operator fun invoke(): Flow<SalaryAndSpent>
}

class GetSalaryUSeCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetSalaryUseCase {
    override fun invoke(): Flow<SalaryAndSpent> =
        repository.getSalary

}