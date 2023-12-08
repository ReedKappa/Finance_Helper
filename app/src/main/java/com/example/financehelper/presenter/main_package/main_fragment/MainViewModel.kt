package com.example.financehelper.presenter.main_package.main_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Finance
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.domain.GetSalaryUseCase
import com.example.financehelper.domain.GetWalletsOrderedUseCase
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getSalaryUseCase: GetSalaryUseCase,
    private val getWalletsOrderedUseCase: GetWalletsOrderedUseCase,
): ViewModel() {

    private val _financeList = MutableLiveData<List<Finance>>()
    val financeList: LiveData<List<Finance>>
        get() = _financeList

//    private val _salary = MutableLiveData<SalaryAndSpent>()
//    val salary: LiveData<SalaryAndSpent>
//        get() = _salary
//
//    private val _wallets = MutableLiveData<List<Wallet>>()
//    val wallets: LiveData<List<Wallet>>
//        get() = _wallets


    fun getSalaryAndWallets() {
        viewModelScope.launch {
            getSalaryUseCase().combine(
                getWalletsOrderedUseCase()
            ) { salaryFlow, walletsFlow ->
                salaryFlow to walletsFlow
            }.collect {
                val result = mutableListOf<Finance>()
                result.add(it.first)
                result.addAll(it.second)
                _financeList.postValue(
                    result
                )
            }
        }
    }

//    fun getSalary() {
//        viewModelScope.launch {
//            getSalaryUseCase().collect {
//                _salary.postValue(it)
//            }
//        }
//    }
//
//    fun getWallets() {
//        viewModelScope.launch {
//            getWalletsOrderedUseCase().collect {
//                _wallets.postValue(it)
//            }
//        }
//    }
}