package com.example.financehelper.presenter.main_package.main_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Finance
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.repository.FinanceRepository
import com.example.financehelper.domain.GetAllSpendingsUseCase
import com.example.financehelper.domain.GetCertainWalletSpendingsUseCase
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetWalletNamesUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getWalletNamesUseCase: GetWalletNamesUseCase,
    private val getSalaryUseCase: GetSalaryUseCase,
    private val getAllSpendingsUseCase: GetAllSpendingsUseCase,
    private val getCertainWalletSpendingsUseCase: GetCertainWalletSpendingsUseCase,
): ViewModel() {
    private val _walletNames = MutableLiveData<List<Finance>>()
    val walletNames: LiveData<List<Finance>>
        get() = _walletNames

    private val _totalSpent = MutableLiveData<Double>()
    val totalSpent: LiveData<Double>
        get() = _totalSpent

    private val _certainWalletSpent = MutableLiveData<List<Double>>()
    val certainWalletSpent: LiveData<List<Double>>
        get() = _certainWalletSpent

    fun getWalletNames() {
        viewModelScope.launch {
            val walletNamesResult = getWalletNamesUseCase()
            val salaryResult = getSalaryUseCase()
            if (walletNamesResult.isSuccess && salaryResult.isSuccess) {
                val salary = salaryResult.getOrNull()
                val wallets = walletNamesResult.getOrNull()
                wallets ?.let {
                    val salaryObject = SalaryAndSpent(salary = salary)
                    val resultList = mutableListOf<Finance>(
                        salaryObject
                    )
                    resultList.addAll(wallets)
                    _walletNames.postValue(resultList)
                }
            }
        }
    }

    fun getAllSpendings() {
        var total: Double = 0.0
        viewModelScope.launch {
            getAllSpendingsUseCase().collect() {
                for (item in it) {
                    total += item
                }
                _totalSpent.postValue(total)
            }
        }
    }

    fun getCertainSpendings() {
        val total = mutableListOf<Double>()
        var totalSpend: Double = 0.0
        viewModelScope.launch {
            for (i in 1..5) {
                getCertainWalletSpendingsUseCase(i).collect() {
                    for (item in it) {
                        totalSpend += item
                    }
                    total.add(totalSpend)
                    totalSpend = 0.0
                }
            }
        }
    }
}