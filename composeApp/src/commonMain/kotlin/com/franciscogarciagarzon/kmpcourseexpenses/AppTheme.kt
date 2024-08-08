package com.franciscogarciagarzon.kmpcourseexpenses

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colors = MaterialTheme.colors.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp),
        )
    ){
        content()
    }
}

@Composable
fun getColorsTheme(): AppPalette{
    val isDarkMode = false

    val CategoryColor = Color(0xFF6A66FF)
    val ExpenseItemColor = if(isDarkMode) Color(0xFF090808) else Color(0xFFF1F1F1)
    val BackgroundColor = if(isDarkMode) Color (0xFF1E1C1C) else Color.White
    val TextColor = if(isDarkMode) Color.White else Color.Black
    val AddIconColor =  if(isDarkMode) CategoryColor else Color.Black
    val ArrowRoundColor = if(isDarkMode) CategoryColor else Color.Gray.copy(alpha = .2f)
    return AppPalette(CategoryColor,
        ExpenseItemColor, BackgroundColor, TextColor, AddIconColor, ArrowRoundColor
    )
}

data class AppPalette(
    val categoryColor: Color,
    val expenseItemColor: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val addIconColor: Color,
    val arrowRoundColor: Color,
)
