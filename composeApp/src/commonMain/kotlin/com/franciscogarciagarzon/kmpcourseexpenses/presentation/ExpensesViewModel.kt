package com.franciscogarciagarzon.kmpcourseexpenses.presentation


import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseCategory
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseRepositoryContract
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
    private val allExpenses = repository.getAllExpenses()

    init {
        getAllExpenses()
    }
    fun addExpense(expense: Expense){
        viewModelScope.launch {
            repository.addExpense(expense)
            updateState()
        }
    }

    fun editExpense(expense: Expense){
        viewModelScope.launch {
            repository.editExpense(expense)
            updateState()
        }
    }
    fun removeExpense(expense: Expense){
        viewModelScope.launch {
            repository.removeExpense(expense)
            updateState()
        }
    }
    fun getExpenseWithId(id: Long): Expense{
        return allExpenses.first{it.id == id}
    }

    private fun getAllExpenses(){
        viewModelScope.launch{
            updateState()
        }
    }

    private fun updateState(){
        _uiState.update { state ->
            state.copy(expenseList =  allExpenses, total = allExpenses.sumOf { it.amount })
        }
    }

    fun getCategories(): List<ExpenseCategory>{
        return repository.getCategories()
    }
}
