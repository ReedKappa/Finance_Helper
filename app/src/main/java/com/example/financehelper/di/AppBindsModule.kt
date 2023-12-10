package com.example.financehelper.di

import android.app.Application
import android.content.Context
import com.example.financehelper.data.repository.FinanceRepository
import com.example.financehelper.data.repository.FinanceRepositoryImpl
import com.example.financehelper.domain.ChangeMoneyValuesUseCase
import com.example.financehelper.domain.ChangeMoneyValuesUseCaseImpl
import com.example.financehelper.domain.GetAllWalletsUseCase
import com.example.financehelper.domain.GetAllWalletsUseCaseImpl
import com.example.financehelper.domain.GetCertainWalletUseCase
import com.example.financehelper.domain.GetCertainWalletUseCaseImpl
import com.example.financehelper.domain.GetPurchasesOrderedUseCase
import com.example.financehelper.domain.GetPurchasesOrderedUseCaseImpl
import com.example.financehelper.domain.GetSalaryFlowUSeCaseImpl
import com.example.financehelper.domain.GetSalaryFlowUseCase
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetSalaryUseCaseImpl
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
    fun bindGetSalaryFlowUseCase(useCase: GetSalaryFlowUSeCaseImpl): GetSalaryFlowUseCase

    @Binds
    fun bindGetWalletsOrderedUseCase(useCase: GetWalletsOrderedUseCaseImpl): GetWalletsOrderedUseCase

    @Binds
    fun bindUpsertSalaryUseCase(useCase: UpsertSalaryUseCaseImpl): UpsertSalaryUseCase

    @Binds
    fun bindUpsertWalletsUseCase(useCase: UpsertWalletsUseCaseImpl): UpsertWalletsUseCase

    @Binds
    fun bindIsOnboardingRequiredUseCase(useCase: IsOnboardingRequiredUSeCaseImpl): IsOnboardingRequiredUseCase

    @Binds
    fun bindGetAllWalletsUseCase(useCase: GetAllWalletsUseCaseImpl): GetAllWalletsUseCase

    @Binds
    fun bindGetCertainWalletUseCase(useCase: GetCertainWalletUseCaseImpl): GetCertainWalletUseCase

    @Binds
    fun bindGetSalaryUseCase(useCase: GetSalaryUseCaseImpl): GetSalaryUseCase

    companion object {
        @Provides
        fun provideContext(app: Application): Context =
            app.applicationContext

        @Provides
        @Singleton
        fun provideResourceProvider(context: Context) = ResourceProvider(context)

    }
}