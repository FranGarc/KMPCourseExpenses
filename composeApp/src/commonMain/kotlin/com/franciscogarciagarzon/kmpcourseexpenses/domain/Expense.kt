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
import kmpcourseexpenses.composeapp.generated.resources.Res
import kmpcourseexpenses.composeapp.generated.resources.category_car
import kmpcourseexpenses.composeapp.generated.resources.category_coffee
import kmpcourseexpenses.composeapp.generated.resources.category_groceries
import kmpcourseexpenses.composeapp.generated.resources.category_house
import kmpcourseexpenses.composeapp.generated.resources.category_others
import kmpcourseexpenses.composeapp.generated.resources.category_party
import kmpcourseexpenses.composeapp.generated.resources.category_snacks
import org.jetbrains.compose.resources.StringResource

enum class ExpenseCategory(val icon: ImageVector,  val label: StringResource){
    Groceries(Icons.Default.FoodBank, Res.string.category_groceries),
    Party(Icons.Default.PartyMode, Res.string.category_party),
    Snacks(Icons.Default.Fastfood, Res.string.category_snacks),
    Coffee(Icons.Default.Coffee, Res.string.category_coffee),
    Car(Icons.Default.ElectricCar, Res.string.category_car),
    House(Icons.Default.House, Res.string.category_house),
    Others(Icons.Default.ViewCozy, Res.string.category_others)
}

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category:ExpenseCategory,
    val description: String
){
    val icon = category.icon
}
