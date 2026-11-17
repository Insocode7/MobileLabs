package practice.task1

// Задача 1. Создать data class Event со строковым временем суток.
// Файл самодостаточен: его можно целиком запустить в Kotlin Playground.

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int
)

fun main() {
    val event = Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", "Evening", 15)
    println(event)
}
