package com.franciscogarciagarzon.kmpcourseexpenses.data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.franciscogarciagarzon.kmpcourseexpenses.db.AppDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:AppDatabase.db")
        AppDatabase.Schema.create(driver)
        return driver
    }
}