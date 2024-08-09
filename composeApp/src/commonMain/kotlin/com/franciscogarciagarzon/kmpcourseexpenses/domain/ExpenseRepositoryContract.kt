package com.franciscogarciagarzon.kmpcourseexpenses.domain

interface ExpenseRepositoryContract {
    fun getAllExpenses(): List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun removeExpense(expense: Expense): List<Expense>
    fun getCategories(): List<ExpenseCategory>
}