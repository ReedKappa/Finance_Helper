package com.example.financehelper.presenter.main_package.add_salary_package

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.domain.UpsertSalaryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddSalaryViewModel @Inject constructor(
    private val upsertSalaryUseCase: UpsertSalaryUseCase
) : ViewModel() {
    fun upsertPurchase(salary:Double) {
        viewModelScope.launch {
            upsertSalaryUseCase(SalaryAndSpent(
                salary
            ))
        }
    }
}