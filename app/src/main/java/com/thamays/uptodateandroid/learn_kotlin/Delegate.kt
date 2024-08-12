package com.thamays.uptodateandroid.learn_kotlin

class ClassA {
    var value: String = "Hello"
}

//class ClassB {
//    var classA = ClassA()
//    var myProperty: String by classA
//}


fun main() {
    println("First Time")
    println(myLazyValue)
    println("-------------")
    println("Second Time")
    println(myLazyValue)
}

val myLazyValue: String by lazy {
    println("Computed!")
    "Hello, Kotlin!"
}
