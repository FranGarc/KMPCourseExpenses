package com.franciscogarciagarzon.kmpcourseexpenses

import TitleTopBarTypes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.franciscogarciagarzon.kmpcourseexpenses.navigation.Navigation
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.core.context.KoinContext


@Composable
@Preview
fun App() {
    PreComposeApp {
        KoinContext {

            val colors = getColorsTheme()


            AppTheme {
                val navigator = rememberNavigator()
                val titleTopBar = getTitleTopAppBar(navigator)
                val isEditOrAddExpense = titleTopBar != TitleTopBarTypes.DAHSBOARD.value
                Scaffold(
                    modifier = Modifier.fillMaxWidth(),
                    topBar = {
                        TopAppBar (elevation = 0.dp,
                            title = {
                                Text(text = titleTopBar, fontSize = 25.sp, color = colors.textColor)
                            },
                            navigationIcon = {
                                val iconType = if(isEditOrAddExpense){
                                    TopBarIcons.ADD_OR_EDIT
                                }else{
                                    TopBarIcons.DASHBOARD
                                }
                                IconButton(
                                    onClick = {
                                        navigator.popBackStack()
                                    }
                                ){
                                    Icon(modifier = Modifier.padding(start = 16.dp),
                                        imageVector = iconType.icon,
                                        tint = colors.textColor,
                                        contentDescription =iconType.contentDescription
                                    )
                                }
                            },
                            backgroundColor = colors.backgroundColor
                        )
                    },
                    floatingActionButton = {
                        if(!isEditOrAddExpense){
                            FloatingActionButton(
                                modifier = Modifier.padding(8.dp),
                                onClick = { navigator.navigate("/addExpense") },
                                shape = RoundedCornerShape(50),
                                backgroundColor = colors.addIconColor,
                                contentColor = Color.White
                            ){
                                Icon(imageVector = Icons.Default.Add,
                                    tint = Color.White,
                                    contentDescription = "Floating Icon"
                                )
                            }
                        }
                    }

                ) {
                    Navigation(navigator)
                }
            }
        }
    }
}

enum class TopBarIcons(val icon: ImageVector, val contentDescription: String){
    DASHBOARD(icon = Icons.Default.Apps, "Dashboard icon"),
    ADD_OR_EDIT(icon = Icons.AutoMirrored.Filled.ArrowBack, "Back Arrow Icon"    )
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String{
    var titleTopBar = TitleTopBarTypes.DAHSBOARD
    val isOnAddExpenses = navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpense/{id}?")
    if(isOnAddExpenses){
        titleTopBar = TitleTopBarTypes.ADD
    }
    val isOnEditExpenses = navigator.currentEntry.collectAsState(null).value?.path<Long>("id") != null
    if(isOnEditExpenses){
        titleTopBar = TitleTopBarTypes.EDIT
    }
    return titleTopBar.value
}