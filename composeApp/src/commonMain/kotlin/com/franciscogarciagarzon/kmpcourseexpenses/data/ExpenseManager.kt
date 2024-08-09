package com.franciscogarciagarzon.kmpcourseexpenses.data

import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    val fakeExpenseList = mutableListOf<Expense>(
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.Car,
            description = "Gasolina"
        ),
        Expense(
            id = currentId++,
            amount = 30.50,
            category = ExpenseCategory.Groceries,
            description = "frescos"
        ),
        Expense(
            id = currentId++,
            amount = 2300.0,
            category = ExpenseCategory.House,
            description = "muebles"
        ),
        Expense(
            id = currentId++,
            amount = 20.75,
            category = ExpenseCategory.Party,
            description = "fiesta"
        ),
        Expense(
            id = currentId++,
            amount = 7.50,
            category = ExpenseCategory.Coffee,
            description = "desayuno"
        ),
        Expense(
            id = currentId++,
            amount = 17.50,
            category = ExpenseCategory.Others,
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
            ExpenseCategory.Car,
            ExpenseCategory.Others,
            ExpenseCategory.Coffee,
            ExpenseCategory.Party,
            ExpenseCategory.House,
            ExpenseCategory.Groceries,

        )
    }
}