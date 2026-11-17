package lessons.collections

fun main() {
    println("ARRAY")
    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarArray = rockPlanets + gasPlanets
    println(solarArray.joinToString())
    solarArray[3] = "Little Earth" // val запрещает переназначение ссылки, не элемента.
    println("Updated index 3: ${solarArray[3]}")
    // solarArray[8] = "Pluto" было бы ошибкой: размер массива фиксирован.
    val newSolarArray = solarArray + "Pluto"
    println("New array size: ${newSolarArray.size}")

    println("\nLIST")
    val planets = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println("Size: ${planets.size}")
    println("Index 2: ${planets[2]}")
    println("Index 3: ${planets.get(3)}")
    println("Earth index: ${planets.indexOf("Earth")}")
    println("Pluto index: ${planets.indexOf("Pluto")}")
    for (planet in planets) println(planet)
    val mutablePlanets = planets.toMutableList()
    mutablePlanets.add("Pluto")
    mutablePlanets.add(3, "Theia")
    mutablePlanets[3] = "Future Moon"
    println("Updated list: $mutablePlanets")
    mutablePlanets.removeAt(9)
    mutablePlanets.remove("Future Moon")
    println("Contains Pluto: ${mutablePlanets.contains("Pluto")}")
    println("Contains Future Moon: ${"Future Moon" in mutablePlanets}")

    println("\nSET")
    val uniquePlanets = planets.toMutableSet()
    println("Size: ${uniquePlanets.size}")
    uniquePlanets.add("Pluto")
    uniquePlanets.add("Pluto") // Повторное добавление не создаёт дубликат.
    println("After adding Pluto twice: ${uniquePlanets.size}")
    uniquePlanets.remove("Pluto")
    println("After removal: ${uniquePlanets.size}")

    println("\nMAP")
    // Учебные числа из codelab; не актуальный каталог спутников планет.
    val moons = mutableMapOf("Mercury" to 0, "Venus" to 0, "Earth" to 1,
        "Mars" to 2, "Jupiter" to 79, "Saturn" to 82, "Uranus" to 27, "Neptune" to 14)
    moons["Pluto"] = 5
    println("Size after adding Pluto: ${moons.size}")
    println("Pluto: ${moons["Pluto"]}")
    println("Theia: ${moons["Theia"]}") // Неизвестный ключ даёт null.
    moons.remove("Pluto")
    moons["Jupiter"] = 78
    println("Size after removal: ${moons.size}")
    println("Updated Jupiter: ${moons["Jupiter"]}")
}
