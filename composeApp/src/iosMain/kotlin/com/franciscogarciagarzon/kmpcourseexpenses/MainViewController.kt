package com.franciscogarciagarzon.kmpcourseexpenses

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin(){
    startKoin{
        modules(appModule())
//        modules(appModule(AppDatabase.invoke(DatabaseDriverFactory().createDriver())))
    }.koin
}