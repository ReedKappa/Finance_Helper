package com.example.financehelper.presenter.main_package.show_purchase_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.domain.GetPurchasesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

class ShowPurchasesViewModel @Inject constructor(
    private val getPurchasesUseCase: GetPurchasesUseCase,
) : ViewModel() {
    private val _purchases = MutableLiveData<List<Purchase>>()
    val purchases: LiveData<List<Purchase>>
        get() = _purchases

    fun getPurchasesList(id: Int) {
        viewModelScope.launch {
            val getPurchasesResult = getPurchasesUseCase(id)
            if (getPurchasesResult.isSuccess) {
                val allPurchases = getPurchasesResult.getOrNull()
                Log.d(this@ShowPurchasesViewModel::class.simpleName, allPurchases.toString())
                _purchases.postValue(allPurchases.let {
                    it
                })
            }
        }
    }
}