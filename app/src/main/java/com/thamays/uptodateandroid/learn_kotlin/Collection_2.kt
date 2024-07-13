package com.thamays.uptodateandroid.learn_kotlin

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double,
    val discount: Double,
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69,
        discount = 2.5
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49,
        discount = 0.0
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59,
        discount = 3.0
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49,
        discount = 5.5
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39,
        discount = 7.5
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79,
        discount = 0.5
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39,
        discount = 1.5
    )
)

fun main() {
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
    println()

    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }

    println("Full menu:")
    fullMenu.forEach {
        println(it)
    }
    println()

    val softBakeMenu = cookies.filter {
        it.softBaked
    }

    println("Soft cookies:")
    softBakeMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()

    val groupedMenu = cookies.groupBy {
        it.softBaked
    }

    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    val (hasFilling, notFilling) = cookies.partition { it.hasFilling }
    println("With Filling:")
    hasFilling.forEach {
        println(it.name)
    }
    println()
    println("Without Filling:")
    notFilling.forEach {
        println(it.name)
    }
    println()

    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")
    println()

    val sumOf = cookies.sumOf { cookie -> cookie.price }
    println("Total price: $${sumOf}")
    println()

    val sortByDiscount = cookies.sortedBy { it.discount }
    println("Sorted By Discount:")
    sortByDiscount.forEach {
        println(it.name)
    }
    println()
}
