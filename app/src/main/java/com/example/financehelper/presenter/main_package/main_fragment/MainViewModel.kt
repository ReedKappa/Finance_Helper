package com.example.financehelper.presenter.main_package.main_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Finance
import com.example.financehelper.domain.GetSalaryFlowUseCase
import com.example.financehelper.domain.GetWalletsOrderedUseCase
import com.example.financehelper.domain.ResetUseCase
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getSalaryFlowUseCase: GetSalaryFlowUseCase,
    private val getWalletsOrderedUseCase: GetWalletsOrderedUseCase,
    private val resetUseCase: ResetUseCase,
): ViewModel() {

    private val _financeList = MutableLiveData<List<Finance>>()
    val financeList: LiveData<List<Finance>>
        get() = _financeList


    fun getSalaryAndWallets() {
        viewModelScope.launch {
            getSalaryFlowUseCase().combine(
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

    fun resetProgress() {
        viewModelScope.launch {
            resetUseCase()
        }
    }
}