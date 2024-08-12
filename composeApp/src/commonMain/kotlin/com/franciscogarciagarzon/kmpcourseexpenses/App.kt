package com.franciscogarciagarzon.kmpcourseexpenses

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseManager
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseRepository
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpensesViewModel
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpensesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val colors = getColorsTheme()
    val viewModel = ExpensesViewModel(ExpenseRepository(ExpenseManager))
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppTheme {
//        var showContent by remember { mutableStateOf(false) }

        ExpensesScreen(uiState , {})
        /*
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
        */
    }
}