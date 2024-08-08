package com.franciscogarciagarzon.kmpcourseexpenses.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.ElectricCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.PartyMode
import androidx.compose.material.icons.filled.ViewCozy
import androidx.compose.ui.graphics.vector.ImageVector

enum class ExpenseCategory(val icon: ImageVector){
    Groceries(Icons.Default.FoodBank),
    Party(Icons.Default.PartyMode),
    Snacks(Icons.Default.Fastfood),
    Coffee(Icons.Default.Coffee),
    Car(Icons.Default.ElectricCar),
    House(Icons.Default.House),
    Others(Icons.Default.ViewCozy)
}

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category:ExpenseCategory,
    val description: String
){
    val icon = category.icon
}
