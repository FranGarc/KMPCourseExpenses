package com.franciscogarciagarzon.kmpcourseexpenses.presentation


import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseRepositoryContract
import com.franciscogarciagarzon.kmpcourseexpenses.utils.KMMLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

data class ExpenseUiState(
    val expenseList: List<Expense> = emptyList(),
    val total: Double = 0.0
)

class ExpensesViewModel(private val repository: ExpenseRepositoryContract): ViewModel() {
    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState = _uiState.asStateFlow()
    private var allExpenses: MutableList<Expense> = mutableListOf()

    init {
        getAllExpenses()
    }

    private fun updateExpensesList(){
        viewModelScope.launch {
            allExpenses = repository.getAllExpenses().toMutableList()
            updateState()
        }
    }
    fun addExpense(expense: Expense){
        viewModelScope.launch {
            repository.addExpense(expense)
            updateExpensesList()
        }
    }

    fun editExpense(expense: Expense){
        viewModelScope.launch {
            repository.editExpense(expense)
            updateExpensesList()
        }
    }
    fun removeExpense(expense: Expense){
        KMMLogger().d("removeExpense: ${expense}")
        viewModelScope.launch {
            repository.removeExpense(expense)
            updateExpensesList()
        }
    }
    fun getExpenseWithId(id: Long): Expense{
        return allExpenses.first{it.id == id}
    }

    private fun getAllExpenses(){
        viewModelScope.launch{
            updateExpensesList()
        }
    }

    private fun updateState(){
        _uiState.update { state ->
            val subtotal =  allExpenses.sumOf { it.amount }
            val formattedSubtotal = String.format("%.2f", subtotal)
            KMMLogger().d("subtotal: ${subtotal}")
            KMMLogger().d("formattedSubtotal: ${formattedSubtotal}")

            state.copy(expenseList =  allExpenses, total = formattedSubtotal.toDouble())
        }
    }

    fun getCategories(): List<ExpenseCategory>{
        return repository.getCategories()
    }
}
