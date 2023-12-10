package com.example.financehelper.domain

import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetSalaryFlowUseCase {
    operator fun invoke(): Flow<SalaryAndSpent>
}

class GetSalaryFlowUSeCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetSalaryFlowUseCase {
    override fun invoke(): Flow<SalaryAndSpent> =
        repository.getSalary

}