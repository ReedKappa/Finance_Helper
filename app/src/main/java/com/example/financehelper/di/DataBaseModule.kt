package com.example.financehelper.di

import android.content.Context
import androidx.room.Room
import com.example.financehelper.data.db.PurchaseDAO
import com.example.financehelper.data.db.PurchaseDataBase
import com.example.financehelper.data.db.SalaryDAO
import com.example.financehelper.data.db.WalletDAO
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun provideDataBase(context: Context): PurchaseDataBase =
        Room.databaseBuilder(
            context,
            PurchaseDataBase::class.java,
            "purchases.db"
        ).build()

    @Provides
    fun providePurchaseDao(db: PurchaseDataBase): PurchaseDAO =
        db.purchaseDAO

    @Provides
    fun provideWalletsDao(db: PurchaseDataBase): WalletDAO =
        db.WalletDAO

    @Provides
    fun provideSalaryDao(db: PurchaseDataBase): SalaryDAO =
        db.salaryDAO
}