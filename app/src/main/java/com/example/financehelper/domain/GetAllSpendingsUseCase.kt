package com.example.financehelper.domain

import com.example.financehelper.data.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetAllSpendingsUseCase {
    operator fun invoke(): Flow<List<Double>>
}

class GetAllSpendingsUseCaseImpl @Inject constructor(
    private val repository: FinanceRepository
): GetAllSpendingsUseCase {
    override fun invoke(): Flow<List<Double>> =
        repository.getAllSpendings

}