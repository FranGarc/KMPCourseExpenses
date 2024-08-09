package com.franciscogarciagarzon.kmpcourseexpenses.utils

expect class LocaleManager{
    val language:String?
    val country: String?

}

expect val currencySymbol: String
expect val currencyCode: String

