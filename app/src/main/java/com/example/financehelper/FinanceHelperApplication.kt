package com.example.financehelper

import android.app.Application
import com.example.financehelper.di.AppComponent
import com.example.financehelper.di.DaggerAppComponent

class FinanceHelperApplication: Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
    }
}