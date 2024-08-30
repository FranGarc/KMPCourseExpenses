package com.franciscogarciagarzon.kmpcourseexpenses.di

import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseManager
import com.franciscogarciagarzon.kmpcourseexpenses.data.ExpenseRepository
import com.franciscogarciagarzon.kmpcourseexpenses.domain.ExpenseRepositoryContract
import com.franciscogarciagarzon.kmpcourseexpenses.presentation.ExpensesViewModel
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module



fun appModule() = module{
    single {ExpenseManager}.withOptions { createdAtStart() }
    single<ExpenseRepositoryContract> {ExpenseRepository(get( )) }
    factory { ExpensesViewModel(get()) }
}