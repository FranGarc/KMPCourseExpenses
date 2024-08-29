package com.franciscogarciagarzon.kmpcourseexpenses.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseManager
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseRepository
import com.franciscogarciagarzon.kmpcourseexpenses.getColorsTheme
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpensesViewModel
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpenseDetailScreen
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpensesScreen
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun Navigation(navigator: Navigator){
    val colors = getColorsTheme()
    val viewModel = viewModel(modelClass = ExpensesViewModel::class){
        ExpensesViewModel(ExpenseRepository(ExpenseManager))
    }

    NavHost(
        modifier = Modifier.background(colors.backgroundColor),
        navigator = navigator,
        initialRoute = "/home",
        ){
        scene(route = "/home"){
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpensesScreen(uiState = uiState){ expense ->
                navigator.navigate("/addExpense/${expense.id}")
            }
        }
        scene(route = "/addExpense/{id}?"){ backStatEntry ->
            val idFromPath = backStatEntry.path<Long>("id")
            val expenseFromEdit = idFromPath?.let { id-> viewModel.getExpenseWithId(id) }

            ExpenseDetailScreen(expenseToEdit = expenseFromEdit, categoryList = viewModel.getCategories()){ expense ->
                if(expenseFromEdit == null){
                    viewModel.addExpense(expense)
                }else{
                    viewModel.editExpense(expense)
                }
                navigator.popBackStack()
            }
        }

    }

}