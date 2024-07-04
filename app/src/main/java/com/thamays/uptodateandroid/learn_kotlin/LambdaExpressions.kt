package com.thamays.uptodateandroid.learn_kotlin

// Original function
fun trick1() {
    println("No treats!")
}

// Redefine the function using a lambda expression
val trick2 = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    return if (isTrick) {
        trick2
    } else {
        treat
    }
}

fun trickOrTreat2(isTrick: Boolean, extraTreat: (Int) -> String?): () -> Unit {
    return if (isTrick) {
        trick2
    } else {
        println(extraTreat(5))
        treat
    }
}

fun trickOrTreat3(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick2
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

fun main() {

    // Store the function in a variable
    // using function reference
    val trickFunction1 = ::trick1

    // Store the lambda expression in a variable
    val trickFunction2 = trick2
    // Call the function using the variable
    trick2()
    // Call the lambda function using the variable
    trickFunction2()

    treat()

    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    treatFunction()
    trickFunction()

    val coin: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val coin2: (Int) -> String = {
        "$it quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction2 = trickOrTreat2(false, coin)
    val treatFunction3 = trickOrTreat2(false, cupcake)
    treatFunction2()
    treatFunction3()

    val treatFunction4 = trickOrTreat3(false, null)
    treatFunction4()

    val treatFunction5 = trickOrTreat3(false) { "$it quarters" }

    repeat(4) {
        treatFunction5()
    }
}
