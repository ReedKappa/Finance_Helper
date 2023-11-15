package com.example.financehelper.di

import com.example.financehelper.data.repository.FinanceRepository
import com.example.financehelper.data.repository.FinanceRepositoryImpl
import com.example.financehelper.domain.AddPurchaseUseCase
import com.example.financehelper.domain.AddPurchaseUseCaseImpl
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetSalaryUseCaseImpl
import com.example.financehelper.domain.GetWalletNamesUseCase
import com.example.financehelper.domain.GetWalletNamesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {

    @Binds
    fun bindFinanceRepository(repositoryImpl: FinanceRepositoryImpl): FinanceRepository

    @Binds
    fun bindGetWalletNamesUseCase(useCase: GetWalletNamesUseCaseImpl): GetWalletNamesUseCase

    @Binds
    fun bindGetSalaryUseCase(useCase: GetSalaryUseCaseImpl): GetSalaryUseCase

    @Binds
    fun bindAddPurchaseUseCase(useCase: AddPurchaseUseCaseImpl): AddPurchaseUseCase
}