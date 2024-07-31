package com.thamays.uptodateandroid.learn_kotlin

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
//    Synchronous
/*
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            printForecast()
            printTemperature()
            println("Have a good day!")
        }
    }

    println("Execution time: ${time / 1000.0} seconds")
*/

//    Asynchronous
/*
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            launch {
                printForecast()
                println("Forecast released!")
            }
            launch {
                printTemperature()
            }
            println("Have a good day!")
        }
    }

    println("Execution time: ${time / 1000.0} seconds")
*/

//    Deferred
/*
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            val forecast: Deferred<String> = async {
                getForecast()
            }

            val temperature: Deferred<String> = async {
                getTemperature()
            }

            println("${forecast.await()} ${temperature.await()}")
            println("Have a good day!")
        }
    }

    println("Execution time: ${time / 1000.0} seconds")
*/

//    coroutineScope
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day!")
        }
    }

    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(2000)
//    println("forecast done")
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
//    println("temperature done")
    return "30\u00b0C"
}

suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}
