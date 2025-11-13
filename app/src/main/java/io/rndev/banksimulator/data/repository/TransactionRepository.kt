package io.rndev.banksimulator.data.repository

import io.rndev.banksimulator.data.Transaction
import io.rndev.banksimulator.data.sampleTransactions
import kotlinx.coroutines.delay

class TransactionRepository {

    suspend fun getAllTransactions(): List<Transaction> {
        // Simular llamada a API o base de datos
        delay(1500)
        return sampleTransactions
    }

    suspend fun getTransactionById(id: String): Transaction? {
        // Simular llamada a API o base de datos
        delay(800)
        return sampleTransactions.find { it.id == id }
    }

    suspend fun getTotalBalance(): Double {
        val transactions = getAllTransactions()
        return transactions.sumOf { it.amount }
    }
}