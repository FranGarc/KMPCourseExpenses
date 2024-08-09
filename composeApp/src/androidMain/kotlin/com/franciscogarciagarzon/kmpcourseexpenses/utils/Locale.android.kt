package com.franciscogarciagarzon.kmpcourseexpenses.utils

import java.util.Currency
import java.util.Locale

actual class LocaleManager{
    actual val language:String?
        get() = getDefaultLocale().language
    actual val country: String?
        get() = getDefaultLocale().country

}


    actual val currencySymbol: String
        get() = getDefaultCurrencySymbol()
    actual val currencyCode: String
        get() = getDefaultCurrencyCode()


fun getDefaultLocale(): Locale = Locale.getDefault()


fun getDefaultCurrencyCode(): String{
    val currency = Currency.getInstance(getDefaultLocale())
    return currency.currencyCode
}
fun getDefaultCurrencySymbol(): String{
    val currency = Currency.getInstance(getDefaultLocale())
    return currency.symbol
}
