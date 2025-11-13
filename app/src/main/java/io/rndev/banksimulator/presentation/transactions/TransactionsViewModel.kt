package io.rndev.banksimulator.presentation.transactions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.rndev.banksimulator.data.Transaction
import io.rndev.banksimulator.data.repository.TransactionRepository
import kotlinx.coroutines.launch

data class TransactionsUiState(
    val transactions: List<Transaction> = emptyList(),
    val totalBalance: Double = 0.0,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class TransactionsViewModel(
    private val repository: TransactionRepository = TransactionRepository()
) : ViewModel() {

    var uiState by mutableStateOf(TransactionsUiState())
        private set

    init {
        loadTransactions()
    }

    private fun loadTransactions() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)

            try {
                val transactions = repository.getAllTransactions()
                val balance = transactions.sumOf { it.amount }

                uiState = uiState.copy(
                    transactions = transactions,
                    totalBalance = balance,
                    isLoading = false
                )
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Error loading transactions: ${e.message}"
                )
            }
        }
    }

    fun refreshTransactions() {
        loadTransactions()
    }
}
