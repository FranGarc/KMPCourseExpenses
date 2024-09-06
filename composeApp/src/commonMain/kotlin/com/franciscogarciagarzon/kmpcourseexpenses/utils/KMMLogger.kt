package com.franciscogarciagarzon.kmpcourseexpenses.utils

import org.lighthousegames.logging.logging

class KMMLogger {
    fun v(message: String) {
        log.v { message }
    }
    fun d(message: String) {
        log.d { message }
    }

    fun i(message: String) {
        log.i { message }
    }

    fun w(message: String) {
        log.w { message }
    }

    fun e(message: String) {
        log.e { message }
    }


    companion object{

        private var log = logging("kmpcourseexpenses")
    }
}