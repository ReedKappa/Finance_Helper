package com.example.financehelper.presenter.main_package.add_purchase_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.domain.AddPurchaseUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPurchaseViewModel @Inject constructor(
    private val addPurchaseUseCase: AddPurchaseUseCase
) : ViewModel() {
    private val _success = MutableLiveData<Boolean>()
    val success
        get() = _success

    fun addPurchase(id: Int, purchaseName: String, purchaseCost: Double) {
        viewModelScope.launch {
            val addPurchaseResult = addPurchaseUseCase(id, purchaseName, purchaseCost)
            _success.postValue(addPurchaseResult.isSuccess)
        }
    }
}