package com.thamays.uptodateandroid.learn_kotlin.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            try {
                println(getWeatherReport())
            } catch (e: AssertionError) {
                println("Caught exception in runBlocking(): $e")
                println("Report unavailable at this time")
            }
            println("Have a nice day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

private suspend fun getWeatherReport() = coroutineScope {
    val forecast: Deferred<String> = async { getForecast() }
    val temperature: Deferred<String> = async { getTemperature() }

    delay(200)
    temperature.cancel()

    forecast.await()
}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

private suspend fun getTemperature(): String {
    delay(2000)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}
