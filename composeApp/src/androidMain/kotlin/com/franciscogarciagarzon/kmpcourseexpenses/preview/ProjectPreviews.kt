package com.franciscogarciagarzon.kmpcourseexpenses.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpenseItem
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpensesScreen


@Preview(showBackground = true)
@Composable
fun ExpensesScreenPreview(){
    ExpensesScreen()
}

@Preview(showBackground = true)
@Composable
fun ExpenseItemPreview(){
    ExpenseItem(
        expense = Expense(
            amount = 10.4,
            category = ExpenseCategory.Others,
            description = "Some Other"),
            onExpenseClick = {}
    )
}