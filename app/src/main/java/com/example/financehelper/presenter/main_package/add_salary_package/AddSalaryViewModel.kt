package com.example.financehelper.presenter.main_package.add_salary_package

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.R
import com.example.financehelper.data.model.SalaryAndSpent
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.di.ResourceProvider
import com.example.financehelper.domain.GetAllWalletsUseCase
import com.example.financehelper.domain.UpsertSalaryUseCase
import com.example.financehelper.domain.UpsertWalletsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

class AddSalaryViewModel @Inject constructor(
    private val upsertSalaryUseCase: UpsertSalaryUseCase,
    private val upsertWalletsUseCase: UpsertWalletsUseCase,
    private val recourceProvider: ResourceProvider,
    private val getAllWalletsUseCase: GetAllWalletsUseCase,
) : ViewModel() {
    fun upsertSalary(salary:Double, onFinish: () -> Unit) {
        viewModelScope.launch {
            val isWalletsEmpty = getAllWalletsUseCase().isEmpty()
            if (isWalletsEmpty) {
                walletList.forEach { (stringId, percent) ->
                    val wallet = Wallet(
                        walletName = recourceProvider.getString(stringId),
                        percents = percent,
                        moneyLeft = (100 * (salary * percent)).roundToInt() / 100.0,
                    )
                    Log.d("check", (stringId to percent).toString())
                    upsertWalletsUseCase(wallet)
                }
            }
            upsertSalaryUseCase(SalaryAndSpent(
                salary
            ))
            onFinish()
        }
    }

    companion object {
        val walletList = listOf(
            R.string.undeferred_expenses_wallet_name to 0.5f,
            R.string.welfare_wallet_name to 0.1f,
            R.string.entertainment_wallet_name to 0.1f,
            R.string.education_wallet_name to 0.1f,
            R.string.free_expenses_wallet_name to 0.1f,
        )
    }
}