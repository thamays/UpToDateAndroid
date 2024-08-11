package com.thamays.uptodateandroid.learn_kotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    runBlocking {
//        val startTime = System.currentTimeMillis()
        val job = async(Dispatchers.Default) {
//            var nextPrintTime = startTime
//            var i = 0
//            while (i < 5) {
////                yield()
//                if (System.currentTimeMillis() >= nextPrintTime) {
//                    println("Hello ${i++}")
//                    nextPrintTime += 500L
//                }
//            }

            repeat(5) {
                println("Hello $it")
                delay(500)
            }
        }

        delay(1000L)
        println("Cancel!")
        job.cancel()
        var result = job.await()
//        job.join()
        println("Done!")
    }
}
