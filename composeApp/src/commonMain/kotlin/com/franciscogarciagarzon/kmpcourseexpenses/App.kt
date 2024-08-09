package com.franciscogarciagarzon.kmpcourseexpenses

import androidx.compose.runtime.*
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseRepository
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpensesViewModel
import com.franciscogarciagarzon.kmpcourseexpenses.ui.ExpensesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val colors = getColorsTheme()
    val viewModel =  ExpensesViewModel(ExpenseRepository())


    AppTheme {
        var showContent by remember { mutableStateOf(false) }
        ExpensesScreen(viewModel.uiState.value, {})
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