package io.rndev.banksimulator.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.rndev.banksimulator.presentation.login.LoginScreen
import io.rndev.banksimulator.presentation.transactiondetail.TransactionDetailScreen
import io.rndev.banksimulator.presentation.transactions.TransactionsScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route, // Start at the login screen
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Transactions.route) {
                        // Avoid stacking login screen
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Transactions.route) {
            TransactionsScreen(
                onTransactionClick = { transactionId ->
                    navController.navigate(Screen.TransactionDetail.createRoute(transactionId))
                }
            )
        }
        composable(Screen.TransactionDetail.route) { backStackEntry ->
            val transactionId = backStackEntry.arguments?.getString("transactionId")
            requireNotNull(transactionId) { "Transaction ID couldn't be found" }
            TransactionDetailScreen(
                transactionId = transactionId,
                onBackClick = { navController.popBackStack() } // Navigate back
            )
        }
    }
}