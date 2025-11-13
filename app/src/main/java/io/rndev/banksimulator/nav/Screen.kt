package io.rndev.banksimulator.nav

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Transactions : Screen("transactions")
    // Route for transaction detail, taking an ID as an argument
    object TransactionDetail : Screen("transaction_detail/{transactionId}") {
        fun createRoute(transactionId: String) = "transaction_detail/$transactionId"
    }
}