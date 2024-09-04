package com.thamays.uptodateandroid.learn_kotlin

/* The com.thamays.uptodateandroid.interview.persistent.main() function doesn't actually get called anywhere in your code;
 the Kotlin compiler uses it as a starting point. */
fun main() {
    test(20, true)
    test(c = 20, true)
    test(c = 20, d = true)
}

fun test(
//  c can't change
    c: Int,
    d: Boolean = false,
    e: Float = 0.133f
) {
//  val keyword to define a variable that is read-only where the value cannot change once it's been assigned.
    val a: Int
//  var keyword to define a variable that is mutable or changeable.
    var b = 0
//  In Kotlin, it's preferred to use val over var when possible.
    /*        Immutability: Declaring a variable with val makes it immutable (constant). Once initialized, its value cannot be changed. This reduces complexity in code because you don't have to track changes or worry about unintended modifications.
            Thread Safety: Immutable variables (val) are inherently thread-safe because their values cannot be altered after initialization. This simplifies concurrent programming by eliminating the risk of data races caused by mutable state.
            Intent and Readability: Using val communicates intent more clearly. It signals to other developers (including your future self) that the value is not meant to change, promoting better understanding and maintainability of the codebase.
            Compiler Optimizations: The Kotlin compiler can optimize code better when it knows that a variable's value won't change (val). This can lead to more efficient bytecode and potentially better performance.
            Avoiding Bugs: Immutable variables reduce the chance of introducing bugs related to unintended modifications. This is especially beneficial in larger codebases or when collaborating with other developers.*/

    when (c) {
        2 -> b += 2
        3 -> b--
        else -> if (d) b++ else b--
    }

    a = 10 + b
    println(a)

    var x : String? = null
    val y = x?.length ?: 0
}
