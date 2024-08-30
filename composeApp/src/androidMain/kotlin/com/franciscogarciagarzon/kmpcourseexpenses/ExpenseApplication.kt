package com.franciscogarciagarzon.kmpcourseexpenses

import android.app.Application
import com.franciscogarciagarzon.kmpcourseexpenses.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ExpenseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@ExpenseApplication)
            androidLogger()
            modules(appModule())
        }
    }
}