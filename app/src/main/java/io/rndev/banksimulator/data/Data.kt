package io.rndev.banksimulator.data

import java.util.Date

enum class TransactionType {
    INCOME,
    EXPENSE
}

data class Transaction(
    val id: String,
    val concept: String,
    val amount: Double,
    val date: Date,
    val type: TransactionType,
    val category: String
)

// Sample data for previewing the UI
val sampleTransactions = listOf(
    Transaction(
        id = "1",
        concept = "Salary",
        amount = 3500.00,
        date = Date(),
        type = TransactionType.INCOME,
        category = "Work"
    ),
    Transaction(
        id = "2",
        concept = "Grocery Shopping",
        amount = -75.50,
        date = Date(System.currentTimeMillis() - 86400000 * 2), // 2 days ago
        type = TransactionType.EXPENSE,
        category = "Food"
    ),
    Transaction(
        id = "3",
        concept = "Netflix Subscription",
        amount = -15.99,
        date = Date(System.currentTimeMillis() - 86400000 * 5), // 5 days ago
        type = TransactionType.EXPENSE,
        category = "Entertainment"
    ),
    Transaction(
        id = "4",
        concept = "Freelance Project",
        amount = 850.00,
        date = Date(System.currentTimeMillis() - 86400000 * 7), // A week ago
        type = TransactionType.INCOME,
        category = "Work"
    ),
        Transaction(
        id = "5",
        concept = "Dinner with friends",
        amount = -120.00,
        date = Date(System.currentTimeMillis() - 86400000 * 10), // 10 days ago
        type = TransactionType.EXPENSE,
        category = "Social"
    )
)
