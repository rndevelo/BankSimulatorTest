package io.rndev.banksimulator.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.rndev.banksimulator.data.repository.AuthRepository
import kotlinx.coroutines.launch

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false,
    val errorMessage: String? = null,
    val isButtonEnabled: Boolean = false
)

class LoginViewModel(
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun updateUsername(username: String) {
        uiState = uiState.copy(
            username = username,
            isButtonEnabled = username.isNotBlank() && uiState.password.isNotBlank(),
            errorMessage = null
        )
    }

    fun updatePassword(password: String) {
        uiState = uiState.copy(
            password = password,
            isButtonEnabled = uiState.username.isNotBlank() && password.isNotBlank(),
            errorMessage = null
        )
    }

    fun login() {
        if (!uiState.isButtonEnabled) return

        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)

            try {
                val result = authRepository.login(uiState.username, uiState.password)

                if (result.isSuccess) {
                    uiState = uiState.copy(
                        isLoading = false,
                        isLoginSuccessful = true
                    )
                } else {
                    uiState = uiState.copy(
                        isLoading = false,
                        errorMessage = result.message ?: "Login failed"
                    )
                }
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Login failed: ${e.message}"
                )
            }
        }
    }

    fun clearError() {
        uiState = uiState.copy(errorMessage = null)
    }
}
