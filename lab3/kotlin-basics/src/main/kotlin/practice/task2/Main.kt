package practice.task2

// Задача 2. Заменить String на enum Daypart.
// Файл самодостаточен: его можно целиком запустить в Kotlin Playground.

enum class Daypart { MORNING, AFTERNOON, EVENING }

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    val event = Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", Daypart.EVENING, 15)
    println(event)
}
