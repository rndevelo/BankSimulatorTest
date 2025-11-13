package io.rndev.banksimulator.data.repository

import kotlinx.coroutines.delay

data class LoginResult(
    val isSuccess: Boolean,
    val message: String? = null,
    val token: String? = null
)

class AuthRepository {

    suspend fun login(username: String, password: String): LoginResult {
        // Simular llamada a API de autenticación
        delay(2000)

        return when {
            username == "admin" && password == "password" -> {
                LoginResult(
                    isSuccess = true,
                    token = "fake_jwt_token_${System.currentTimeMillis()}"
                )
            }

            username.isBlank() || password.isBlank() -> {
                LoginResult(
                    isSuccess = false,
                    message = "Username and password are required"
                )
            }

            else -> {
                LoginResult(
                    isSuccess = false,
                    message = "Invalid username or password"
                )
            }
        }
    }

    suspend fun logout(): Boolean {
        // Simular limpieza de token/sesión
        delay(500)
        return true
    }
}