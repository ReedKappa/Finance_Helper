package com.example.financehelper.di

import android.app.Application
import android.content.Context
import com.example.financehelper.FinanceHelperApplication
import com.example.financehelper.data.repository.FinanceRepository
import com.example.financehelper.data.repository.FinanceRepositoryImpl
import com.example.financehelper.domain.GetAllSpendingsUseCase
import com.example.financehelper.domain.GetAllSpendingsUseCaseImpl
import com.example.financehelper.domain.GetCertainWalletSPendingsUseCaseImpl
import com.example.financehelper.domain.GetCertainWalletSpendingsUseCase
import com.example.financehelper.domain.GetPurchasesOrderedUseCase
import com.example.financehelper.domain.GetPurchasesOrderedUseCaseImpl
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetSalaryUseCaseImpl
import com.example.financehelper.domain.GetWalletNamesUseCase
import com.example.financehelper.domain.GetWalletNamesUseCaseImpl
import com.example.financehelper.domain.UpsertPurchaseUseCase
import com.example.financehelper.domain.UpsertPurchaseUseCaseImpl
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
    fun bindUpsertPurchaseUseCase(useCase: UpsertPurchaseUseCaseImpl): UpsertPurchaseUseCase

    @Binds
    fun bindGetPurchasesOrderedUseCase(useCase: GetPurchasesOrderedUseCaseImpl): GetPurchasesOrderedUseCase

    @Binds
    fun bindGetAllSpendingsUseCase(useCase: GetAllSpendingsUseCaseImpl): GetAllSpendingsUseCase

    @Binds
    fun bindGetCertainWalletSpendingsUseCase(useCase: GetCertainWalletSPendingsUseCaseImpl): GetCertainWalletSpendingsUseCase

    companion object {
        @Provides
        fun provideContext(app: Application): Context =
            app.applicationContext
    }
}