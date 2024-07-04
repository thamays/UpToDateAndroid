package com.thamays.uptodateandroid.learn_kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

suspend fun fetchData(): String {
    delay(2000)
    return "Data from API"
}

fun main() {
    println("Start")

    val job = GlobalScope.launch {
        try {
            val result = fetchData() // Call suspend function
            println("Result 1: $result") // Print fetched data after coroutine resumes
        } catch (e: CancellationException) {
            println("Coroutine was cancelled: ${e.message}")
        }
    }

    GlobalScope.launch {
        try {
            val result = fetchData() // Call suspend function
            println("Result 2: $result") // Print fetched data after coroutine resumes
        } catch (e: CancellationException) {
            println("Coroutine was cancelled: ${e.message}")
        }
    }

    Thread.sleep(1000)

//    job.cancel()

    println("Doing 1st other work")

    Thread.sleep(3000)

    println("End")
}
