package com.franciscogarciagarzon.kmpcourseexpenses.data

import com.franciscogarciagarzon.kmpcourseexpenses.db.AppDatabase
import com.franciscogarciagarzon.kmpcourseexpenses.db.ExpenseEntity
import com.franciscogarciagarzon.kmpcourseexpenses.di.appModule
import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseRepositoryContract
import com.franciscogarciagarzon.kmpcourseexpenses.utils.KMMLogger
import org.koin.core.logger.Logger
import kotlin.math.exp

class ExpenseRepository(private val expenseManager: ExpenseManager,
    private val appDatabase: AppDatabase): ExpenseRepositoryContract {

        private val queries = appDatabase.expensesDbQueries

    override fun getAllExpenses(): List<Expense> {
        KMMLogger().d("repository.getAllExpenses:")

        return queries.selectAll().executeAsList().map { expenseEntity ->
            Expense(
                id = expenseEntity.id,
                amount = expenseEntity.amount,
                category = ExpenseCategory.valueOf(expenseEntity.categoryName),
                description = expenseEntity.description
            )
        }
//       return expenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
//        expenseManager.addNewExpense(expense)
        KMMLogger().d("repository.addExpense: ${expense}")

        queries.transaction {
            queries.insert(expense.amount, expense.category.name, expense.description)
        }
    }

    override fun editExpense(expense: Expense) {
//        expenseManager.editExpense(expense)
        queries.transaction {
            queries.update(
                id = expense.id,
                amount = expense.amount,
                categoryName = expense.category.name,
                description = expense.description
            )
        }
    }

    override fun removeExpense(expense: Expense): List<Expense> {
//        expenseManager.removeExpense(expense)
        KMMLogger().d("repository.removeExpense: ${expense}")

        queries.transaction {
            queries.delete(
                id= expense.id)
        }
       // return expenseManager.fakeExpenseList
        return getAllExpenses()
    }

    override fun getCategories(): List<ExpenseCategory> {
//        return expenseManager.getCategories()
        return queries.categories().executeAsList().map {
            ExpenseCategory.valueOf(it)
        }
    }
}