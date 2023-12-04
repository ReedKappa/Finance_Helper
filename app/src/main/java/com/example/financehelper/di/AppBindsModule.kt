package com.example.financehelper.di

import android.app.Application
import android.content.Context
import com.example.financehelper.FinanceHelperApplication
import com.example.financehelper.data.repository.FinanceRepository
import com.example.financehelper.data.repository.FinanceRepositoryImpl
import com.example.financehelper.domain.AddPurchaseUseCase
import com.example.financehelper.domain.AddPurchaseUseCaseImpl
import com.example.financehelper.domain.GetPurchasesUseCase
import com.example.financehelper.domain.GetPurchasesUseCaseImpl
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetSalaryUseCaseImpl
import com.example.financehelper.domain.GetWalletNamesUseCase
import com.example.financehelper.domain.GetWalletNamesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppBindsModule {

    @Binds
    @Singleton
    fun bindFinanceRepository(repositoryImpl: FinanceRepositoryImpl): FinanceRepository

    @Binds
    fun bindGetWalletNamesUseCase(useCase: GetWalletNamesUseCaseImpl): GetWalletNamesUseCase

    @Binds
    fun bindGetSalaryUseCase(useCase: GetSalaryUseCaseImpl): GetSalaryUseCase

    @Binds
    fun bindAddPurchaseUseCase(useCase: AddPurchaseUseCaseImpl): AddPurchaseUseCase

    @Binds
    fun bindGetPurchasesUseCase(useCase: GetPurchasesUseCaseImpl): GetPurchasesUseCase

    companion object {
        @Provides
        fun provideContext(app: Application): Context =
            app.applicationContext
    }
}