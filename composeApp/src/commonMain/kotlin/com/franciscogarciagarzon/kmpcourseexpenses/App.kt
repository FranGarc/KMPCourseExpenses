package com.franciscogarciagarzon.kmpcourseexpenses

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseManager
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseRepository
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpensesViewModel
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()
        val viewModel = ExpensesViewModel(ExpenseRepository(ExpenseManager))
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AppTheme {
            ExpensesScreen(uiState , {})
        }
    }

}