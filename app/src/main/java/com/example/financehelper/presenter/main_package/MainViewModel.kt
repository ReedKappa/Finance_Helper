package com.example.financehelper.presenter.main_package

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Finance
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetWalletNamesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getWalletNamesUseCase: GetWalletNamesUseCase,
    private val getSalaryUseCase: GetSalaryUseCase,
): ViewModel() {
    private val _walletNames = MutableLiveData<List<Finance>>()
    val walletNames: LiveData<List<Finance>>
        get() = _walletNames

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

    
}