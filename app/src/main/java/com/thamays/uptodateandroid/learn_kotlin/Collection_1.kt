package com.thamays.uptodateandroid.learn_kotlin

fun main() {

//    Array
    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets

    println(solarSystem[3])
    solarSystem[3] = "Little Earth"
    println(solarSystem[3])
//    solarSystem[8] = "Pluto"
    println()

//    List
    val solarSystemV2 =
        listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemV2.size)
    println(solarSystemV2[2])
    println(solarSystemV2.get(2))
    println(solarSystemV2.indexOf("Earth"))
    println(solarSystemV2.indexOf("Pluto"))
    for (planet in solarSystemV2) {
        println(planet)
    }
    println()

//    MutableList
    val solarSystemV3 =
        mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystemV3.add("Pluto")
    solarSystemV3.add(3, "Theia")
    solarSystemV3[4] = "Future Moon"
    println(solarSystemV3[3])
    println(solarSystemV3[4])

    solarSystemV3.removeAt(9)
    solarSystemV3.remove("Future Moon")
    println(solarSystemV3.contains("Pluto"))
    println("Future Moon" in solarSystemV3)
    println()

//    MutableSet
    val solarSystemV4 =
        mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemV4.size)
    solarSystemV4.add("Pluto")
    println(solarSystemV4.size)
    println(solarSystemV4.contains("Pluto"))
    println("Pluto" in solarSystemV4)
    solarSystemV4.add("Pluto")
    println(solarSystem.size)
    solarSystemV4.remove("Pluto")
    println(solarSystemV4.size)
    println(solarSystemV4.contains("Pluto"))
    println()

//    MutableMapOf
    val solarSystemV5 = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystemV5["Mercury"])
    println(solarSystemV5["Venus"])
    println(solarSystemV5.size)
    solarSystemV5["Pluto"] = 5
    println(solarSystemV5.size)
    println(solarSystemV5["Pluto"])
    println(solarSystemV5.get("Theia"))
    solarSystemV5.remove("Pluto")
    println(solarSystemV5.size)
    solarSystemV5["Jupiter"] = 78
    println(solarSystemV5["Jupiter"])
}
