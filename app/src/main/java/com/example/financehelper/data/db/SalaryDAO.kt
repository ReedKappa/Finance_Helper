package com.example.financehelper.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.financehelper.data.db.model.SalaryAndSpentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SalaryDAO {
    @Upsert
    suspend fun upsertSalary(salaryAndSpentEntity: SalaryAndSpentEntity)

    @Query("SELECT * FROM salary LIMIT 1")
    fun getSalaryFlow(): Flow<SalaryAndSpentEntity>

    @Query("SELECT * FROM salary LIMIT 1")
    suspend fun getSalary(): SalaryAndSpentEntity
}