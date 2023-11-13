package com.example.financehelper.di

import android.content.Context
import com.example.financehelper.FinanceHelperApplication

val Context.appComponent: AppComponent
    get() = when (this) {
        is FinanceHelperApplication -> appComponent
        else -> applicationContext.appComponent
    }