package com.franciscogarciagarzon.kmpcourseexpenses.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseManager
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpenseUiState
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpenseItem
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpensesScreen


@Preview(showBackground = true)
@Composable
fun ExpensesScreenPreview(){
    ExpensesScreen(
        ExpenseUiState(
            ExpenseManager.fakeExpenseList,
            ExpenseManager.fakeExpenseList.sumOf { it.amount }
        ),
        onItemClick = {},
        //onDelete = {},
        )
}

@Preview(showBackground = true)
@Composable
fun ExpenseItemPreview(){
    ExpenseItem(
        expense = ExpenseManager.fakeExpenseList.first(),
            onItemClick = {},
       // onDelete= {}
    )
}