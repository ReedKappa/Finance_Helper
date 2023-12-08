package com.example.financehelper.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financehelper.data.model.SalaryAndSpent

@Entity(tableName = "salary")
data class SalaryAndSpentEntity(
    val salary: Double,
    val moneySpent: Double = 0.0,
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 1
    fun toSalaryAndSpent(): SalaryAndSpent =
        SalaryAndSpent(
            salary, moneySpent
        )
}