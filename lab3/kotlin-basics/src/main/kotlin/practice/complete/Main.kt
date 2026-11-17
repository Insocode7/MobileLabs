package practice.complete

// Итоговое решение объединяет задачи 1–7.
// В задаче 1 daypart был String; после задачи 2 здесь используется enum.
enum class Daypart { MORNING, AFTERNOON, EVENING }

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// Свойство вычисляется при обращении; класс Event не меняется.
val Event.durationOfEvent: String
    get() = if (durationInMinutes < 60) "short" else "long"

fun createEvents(): MutableList<Event> {
    val event1 = Event("Wake up", "Time to get up", Daypart.MORNING, 0)
    val event2 = Event("Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event("Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event("Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event("Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event("Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    val events = mutableListOf(event1, event2, event3, event4, event5, event6)
    return events
}

fun main() {
    val study = Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", Daypart.EVENING, 15)
    println("Tasks 1–2: $study")
    val events = createEvents()
    println("Task 3: ${events.size} events")
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("Task 4: You have ${shortEvents.size} short events.")
    println("Task 5:")
    events.groupBy { it.daypart }.forEach { (daypart, dayEvents) ->
        println("$daypart: ${dayEvents.size} events")
    }
    println("Task 6: Last event of the day: ${events.last().title}")
    println("Task 7: Duration of first event of the day: ${events.first().durationOfEvent}")
}
