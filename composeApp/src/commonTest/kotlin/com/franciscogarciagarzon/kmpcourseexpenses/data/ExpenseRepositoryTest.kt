package com.franciscogarciagarzon.kmpcourseexpenses.data

import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory
import javax.print.attribute.standard.MediaSize.Other
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ExpenseRepositoryTest {
    private val expenseManager = ExpenseManager
    private val repo = ExpenseRepository(expenseManager)

    @Test
    fun `expense list is not empty`() {
        //Given
        val expenseList = mutableListOf<Expense>()
        //When
        expenseList.addAll(repo.getAllExpenses())
        //Then
        assertTrue(expenseList.isNotEmpty())
    }

    @Test
    fun addNewExpense() {
        //Given
        val expenseList = repo.getAllExpenses()
        //When
       repo.addExpense(Expense(amount = 5.4, category = ExpenseCategory.Car, description = "car stuff"))
        //Then
        assertContains(expenseList, expenseList.find { it.id == 7L })
    }

    @Test
    fun editExpense() {
        //Given
        val expenseListBefore = repo.getAllExpenses()

        //When
        val newExpenseId = 7L
        repo.addExpense(
            Expense(
                amount = 5.4,
                category = ExpenseCategory.Car,
                description = "car stuff"
            )
        )

        assertNotNull(expenseListBefore.find { it.id == newExpenseId })

        val updatedExpense = Expense(
            id = newExpenseId,
            amount = 8.0,
            category = ExpenseCategory.Others,
            description = "other stuff"
        )
        repo.editExpense(updatedExpense)

        //Then
        val expenseListAfter = repo.getAllExpenses()
        assertEquals(updatedExpense, expenseListAfter.find { it.id == newExpenseId })
    }

    @Test
    fun removeExpense() {
        //Given

        //When

        //Then
    }

    @Test
    fun getCategories() {
        //Given
        val categoryList = mutableListOf<ExpenseCategory>()
        //When
        categoryList.addAll(repo.getCategories())
        //Then
        assertTrue(categoryList.isNotEmpty())
    }
}