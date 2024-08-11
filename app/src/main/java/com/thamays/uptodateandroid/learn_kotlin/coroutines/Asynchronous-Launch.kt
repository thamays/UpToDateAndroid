package com.thamays.uptodateandroid.learn_kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            launch {
                printForecast()
            }
            launch {
                printTemperature()
            }
            println("Have a nice day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

private suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

private suspend fun printTemperature() {
    delay(2000)
    println("30\u00b0C")
}
