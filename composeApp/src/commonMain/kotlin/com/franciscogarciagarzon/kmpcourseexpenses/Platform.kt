package com.franciscogarciagarzon.kmpcourseexpenses

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform