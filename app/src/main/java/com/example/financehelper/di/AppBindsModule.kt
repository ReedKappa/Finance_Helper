package com.example.financehelper.di

import android.app.Application
import android.content.Context
import com.example.financehelper.data.repository.FinanceRepository
import com.example.financehelper.data.repository.FinanceRepositoryImpl
import com.example.financehelper.domain.ChangeMoneyValuesUseCase
import com.example.financehelper.domain.ChangeMoneyValuesUseCaseImpl
import com.example.financehelper.domain.GetPurchasesOrderedUseCase
import com.example.financehelper.domain.GetPurchasesOrderedUseCaseImpl
import com.example.financehelper.domain.GetSalaryUSeCaseImpl
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetWalletsOrderedUseCase
import com.example.financehelper.domain.GetWalletsOrderedUseCaseImpl
import com.example.financehelper.domain.IsOnboardingRequiredUSeCaseImpl
import com.example.financehelper.domain.IsOnboardingRequiredUseCase
import com.example.financehelper.domain.UpsertPurchaseUseCase
import com.example.financehelper.domain.UpsertPurchaseUseCaseImpl
import com.example.financehelper.domain.UpsertSalaryUseCase
import com.example.financehelper.domain.UpsertSalaryUseCaseImpl
import com.example.financehelper.domain.UpsertWalletsUseCase
import com.example.financehelper.domain.UpsertWalletsUseCaseImpl
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
    fun bindUpsertPurchaseUseCase(useCase: UpsertPurchaseUseCaseImpl): UpsertPurchaseUseCase

    @Binds
    fun bindGetPurchasesOrderedUseCase(useCase: GetPurchasesOrderedUseCaseImpl): GetPurchasesOrderedUseCase

    @Binds
    fun bindChangeMoneyValuesUseCase(useCase: ChangeMoneyValuesUseCaseImpl): ChangeMoneyValuesUseCase

    @Binds
    fun bindGetSalaryUseCase(useCase: GetSalaryUSeCaseImpl): GetSalaryUseCase

    @Binds
    fun bindGetWalletsOrderedUseCase(useCase: GetWalletsOrderedUseCaseImpl): GetWalletsOrderedUseCase

    @Binds
    fun bindUpsertSalaryUseCase(useCase: UpsertSalaryUseCaseImpl): UpsertSalaryUseCase

    @Binds
    fun bindUpsertWalletsUseCase(useCase: UpsertWalletsUseCaseImpl): UpsertWalletsUseCase

    @Binds
    fun bindIsOnboardingRequiredUseCase(useCase: IsOnboardingRequiredUSeCaseImpl): IsOnboardingRequiredUseCase

    companion object {
        @Provides
        fun provideContext(app: Application): Context =
            app.applicationContext
    }
}