package com.thamays.uptodateandroid.learn_kotlin

interface Engine {
    fun start()
}

class GasEngine : Engine {
    override fun start() {
        println("GasEngine started!")
    }
}

class ElectricEngine : Engine {
    override fun start() {
        println("ElectricEngine started!")
    }

}

class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

fun main() {
    val engine = ElectricEngine()
    val car = Car(engine)
    car.start()
}
