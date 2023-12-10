package com.example.financehelper.presenter.main_package.add_purchase_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.domain.ChangeMoneyValuesUseCase
import com.example.financehelper.domain.GetCertainWalletUseCase
import com.example.financehelper.domain.GetSalaryFlowUseCase
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.UpsertPurchaseUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPurchaseViewModel @Inject constructor(
    private val upsertPurchaseUseCase: UpsertPurchaseUseCase,
    private val changeMoneyValuesUseCase: ChangeMoneyValuesUseCase,
    private val getCertainWalletUseCase: GetCertainWalletUseCase,
    private val getSalaryUseCase: GetSalaryUseCase,
) : ViewModel() {
    private val _success = MutableLiveData<Boolean>()
    val success
        get() = _success

    fun upsertPurchase(purchase: Purchase, walletId: Int) {
        viewModelScope.launch {
            val wallet = getCertainWalletUseCase(walletId)
            val salary = getSalaryUseCase()
            changeMoneyValuesUseCase(
                purchase = purchase,
                wallet = wallet,
                salaryAndSpent = salary
            )
        }
    }
}