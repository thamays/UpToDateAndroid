package com.thamays.uptodateandroid.learn_kotlin

fun main() {
    println("Mobile notifications")
    println("-------------------")
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

    println()
    println("Movie-ticket price")
    println("-------------------")

    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println(
        "The movie ticket price for a person aged $senior is \$${
            ticketPrice(
                senior,
                isMonday
            )
        }."
    )

    println()
    println("Temperature converter")
    println("-------------------")

    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { it / 5 * 9 + 32 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { (it - 32) / 9 * 5 + 273.15 }

    println()
    println("Song catalog")
    println("-------------------")

    val song = Song("Hi Hi..", "Thamays", 2020, 2322)
    song.description()

    println()
    println("Internet profile")
    println("-------------------")

    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()

    println()
    println("Foldable phones")
    println("-------------------")

    val newFoldablePhone = FoldablePhone(true)
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.fold()
    newFoldablePhone.checkPhoneScreenLight()

    println()
    println("Special auction")
    println("-------------------")

    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean) : Phone() {

    override fun switchOn() {
        if (!isFolded)
            isScreenLightOn = true
    }

    fun fold() {
        isFolded = true
        switchOff()
    }

    fun unfold() {
        isFolded = false
        switchOn()
    }
}

class Person(
    val name: String,
    private val age: Int,
    private val hobby: String?,
    private val referrer: Person?
) {
    fun showProfile() {
        val referString =
            if (referrer == null) "Doesn't have a referrer." else "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
        println(
            "Name: $name\n" +
                    "Age: $age\n" +
                    "likes to $hobby. $referString"
        )
    }
}

class Song(
    private val title: String,
    private val artist: String,
    private val year: Int,
    private val playCount: Int
) {

    fun isPopular(): Boolean {
        return playCount > 1000
    }

    fun description() {
        println("$title, performed by $artist, was released in $year.")
    }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement =
        String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when (age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 60..100 -> 20
        else -> -1
    }
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages >= 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    } else {
        println("You have $numberOfMessages notifications.")
    }
}
