package com.thamays.uptodateandroid.learn_kotlin.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            val forecast: Deferred<String> = async { getForecast() }
            val temperature: Deferred<String> = async { getTemperature() }
            println("${forecast.await()} ${temperature.await()}")
            println("Have a nice day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

private suspend fun getTemperature(): String {
    delay(2000)
    return "30\u00b0C"
}