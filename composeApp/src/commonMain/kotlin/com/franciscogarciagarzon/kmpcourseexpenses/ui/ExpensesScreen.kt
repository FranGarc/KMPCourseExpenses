package com.franciscogarciagarzon.kmpcourseexpenses.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.franciscogarciagarzon.kmpcourseexpenses.domain.Expense
import com.franciscogarciagarzon.kmpcourseexpenses.getColorsTheme
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpenseUiState
import com.franciscogarciagarzon.kmpcourseexpenses.utils.currencyCode
import com.franciscogarciagarzon.kmpcourseexpenses.utils.currencySymbol
import kmpcourseexpenses.composeapp.generated.resources.Res
import kmpcourseexpenses.composeapp.generated.resources.all_expenses
import kmpcourseexpenses.composeapp.generated.resources.view_all
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpensesScreen(
    uiState: ExpenseUiState,
    onItemClick: (expense: Expense) -> Unit,
    onDelete: (expense: Expense) -> Unit ={},
    ){
    val colors = getColorsTheme()

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Column(modifier = Modifier.background(color = colors.backgroundColor)) {
                ExpensesTotalHeader(uiState.total)
                AllExpensesHeader()
            }
        }

        items(uiState.expenseList){expense ->
            ExpenseItem(expense, onItemClick,
                onDelete,
            )

        }
    }

}



@Composable
fun ExpensesTotalHeader(total: Double){
    Card(shape = RoundedCornerShape(30), backgroundColor = Color.Black, elevation = 5.dp) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(130.dp)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ){
            Text( text = "$currencySymbol$total",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                modifier = Modifier.align(Alignment.CenterEnd), text = currencyCode, color = Color.Gray
            )
        }
    }
}

@Composable
fun AllExpensesHeader(){
    val colors = getColorsTheme()
    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.weight(1f),
                text= stringResource(Res.string.all_expenses),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = colors.textColor
            )
        Button(
            shape = RoundedCornerShape(50),
            onClick = {  //
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ){
            Text(text= stringResource(Res.string.view_all))
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun ExpenseItem(
    expense: Expense,
    onItemClick: (expense: Expense) -> Unit,
    onDelete: (expense: Expense) -> Unit,
){
    val colors = getColorsTheme()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clickable { onItemClick(expense) },
        backgroundColor = colors.expenseItemColor,
        shape = RoundedCornerShape(30)
    ){
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = colors.categoryColor
            ) {
                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = expense.icon,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop,
                    contentDescription = "category icon"
                )
            }

            Column (modifier = Modifier
                .padding(start =8.dp)
                .weight(1f)
            ) {
                Text(
                    text = stringResource(expense.category.label),
//                    text = expense.category.name,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = colors.textColor
                )
                Text(
                    text = expense.description,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "$currencySymbol${expense.amount}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Gray
            )

            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = colors.contrastColor
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(10.dp),
                    onClick = {
                        onDelete(expense)
                    }
                ){
                    Image(

                        imageVector = Icons.Default.Delete ,
                        colorFilter = ColorFilter.tint(Color.White),
                        contentScale = ContentScale.Crop,
                        contentDescription = "delete icon"
                    )
                }

            }
        }
    }
}