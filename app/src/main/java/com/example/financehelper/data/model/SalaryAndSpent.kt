package com.example.financehelper.data.model

import com.example.financehelper.data.db.model.SalaryAndSpentEntity

data class SalaryAndSpent (
    val salary: Double,
    val moneySpent: Double = 0.0
): Finance {
    fun toSalaryAndSpentEntity(): SalaryAndSpentEntity =
        SalaryAndSpentEntity(
            salary, moneySpent
        )
}