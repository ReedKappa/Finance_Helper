package com.example.financehelper.presenter.main_package.show_purchase_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.domain.GetPurchasesOrderedUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowPurchasesViewModel @Inject constructor(
    private val getPurchasesOrderedUseCase: GetPurchasesOrderedUseCase,
) : ViewModel() {
    private val _purchases = MutableLiveData<List<Purchase>>()
    val purchases: LiveData<List<Purchase>>
        get() = _purchases


    fun getPurchasesOrdered(walletId: Int) {
        viewModelScope.launch {
            getPurchasesOrderedUseCase(walletId).collect() {
                _purchases.postValue(it)
            }
        }
    }

}