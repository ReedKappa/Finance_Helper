package com.example.financehelper.presenter.main_package.add_purchase_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.domain.UpsertPurchaseUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPurchaseViewModel @Inject constructor(
    private val upsertPurchaseUseCase: UpsertPurchaseUseCase
) : ViewModel() {
    private val _success = MutableLiveData<Boolean>()
    val success
        get() = _success

    fun upsertPurchase(purchase: Purchase) {
        viewModelScope.launch {
            val upsertPurchaseResult = upsertPurchaseUseCase(purchase)
        }
    }
}