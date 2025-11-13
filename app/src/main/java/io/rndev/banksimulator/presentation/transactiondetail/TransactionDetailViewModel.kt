package io.rndev.banksimulator.presentation.transactiondetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.rndev.banksimulator.data.Transaction
import io.rndev.banksimulator.data.repository.TransactionRepository
import kotlinx.coroutines.launch

data class TransactionDetailUiState(
    val transaction: Transaction? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class TransactionDetailViewModel(
    private val repository: TransactionRepository = TransactionRepository()
) : ViewModel() {

    var uiState by mutableStateOf(TransactionDetailUiState())
        private set

    fun loadTransactionById(id: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)

            try {
                val transaction = repository.getTransactionById(id)

                uiState = uiState.copy(
                    transaction = transaction,
                    isLoading = false,
                    errorMessage = if (transaction == null) "Transaction not found" else null
                )
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Error loading transaction: ${e.message}"
                )
            }
        }
    }
}
