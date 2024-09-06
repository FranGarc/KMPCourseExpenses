package com.franciscogarciagarzon.kmpcourseexpenses.data

import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    val fakeExpenseList = mutableListOf<Expense>(
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.CAR,
            description = "Gasolina"
        ),
        Expense(
            id = currentId++,
            amount = 30.50,
            category = ExpenseCategory.GROCERIES,
            description = "frescos"
        ),
        Expense(
            id = currentId++,
            amount = 2300.0,
            category = ExpenseCategory.HOUSE,
            description = "muebles"
        ),
        Expense(
            id = currentId++,
            amount = 20.75,
            category = ExpenseCategory.PARTY,
            description = "fiesta"
        ),
        Expense(
            id = currentId++,
            amount = 7.50,
            category = ExpenseCategory.COFFEE,
            description = "desayuno"
        ),
        Expense(
            id = currentId++,
            amount = 17.50,
            category = ExpenseCategory.OTHER,
            description = "regalo"
        ),
    )

    fun addNewExpense(expense: Expense){
        fakeExpenseList.add(expense.copy(id = currentId++))
    }
    fun editExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst {
            it.id == expense.id
        }
        if(index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }
    fun removeExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst {
            it.id == expense.id
        }
        fakeExpenseList.removeAt(index)
    }
    fun getCategories(): List<ExpenseCategory>{
        return listOf(
            ExpenseCategory.CAR,
            ExpenseCategory.OTHER,
            ExpenseCategory.COFFEE,
            ExpenseCategory.PARTY,
            ExpenseCategory.HOUSE,
            ExpenseCategory.SNACKS,
            ExpenseCategory.GROCERIES,

        )
    }
}