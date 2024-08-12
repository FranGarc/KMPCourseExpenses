package com.franciscogarciagarzon.kmpcourseexpenses.data

import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseRepositoryContract

class ExpenseRepository(private val expenseManager: ExpenseManager ): ExpenseRepositoryContract {

    override fun getAllExpenses(): List<Expense> {
       return expenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        expenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun removeExpense(expense: Expense): List<Expense> {
        expenseManager.removeExpense(expense)
        return expenseManager.fakeExpenseList
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }
}