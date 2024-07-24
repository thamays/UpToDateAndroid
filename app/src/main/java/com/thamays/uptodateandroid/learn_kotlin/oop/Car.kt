package com.thamays.uptodateandroid.learn_kotlin.oop

// Primary Constructor - Default Constructor / Parameterized Constructor
class Car constructor(
//  Properties / variables
    val model: String,
    val year: Int,
    val colour: String
) {

//  Secondary Constructor
    constructor(model: String, year: Int, colour: String, isManual: Boolean)
            : this(model = model, year = year, colour = colour)

//  Methods / Functions
    fun enginStart() {
        println("Started")
    }

    fun enginStop() {
        println("Started")
    }

    fun applyBreak() {
        println("Break Applied")
    }
}


