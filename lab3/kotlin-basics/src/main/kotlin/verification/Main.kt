package verification

import practice.complete.Daypart
import practice.complete.Event
import practice.complete.createEvents
import practice.complete.durationOfEvent
import lessons.functions.cookies
import kotlin.math.abs

fun main() {
    val events = createEvents()
    check(events.size == 6)
    check(events[1].description == null)
    check(events.filter { it.durationInMinutes < 60 }.size == 5)
    check(events.groupBy { it.daypart }.mapValues { it.value.size } ==
        mapOf(Daypart.MORNING to 2, Daypart.AFTERNOON to 3, Daypart.EVENING to 1))
    check(events.last().title == "Check out latest Android Jetpack library")
    // Важная граница условия: ровно 60 минут — уже long.
    for ((minutes, expected) in listOf(0 to "short", 59 to "short", 60 to "long", 61 to "long")) {
        check(Event("Boundary", daypart = Daypart.MORNING, durationInMinutes = minutes).durationOfEvent == expected)
    }
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    check(events.size == 6) // filter не меняет исходный список.
    events.add(Event("Extra", daypart = Daypart.EVENING, durationInMinutes = 5))
    check(events.size == 7 && shortEvents.size == 5)
    check(cookies.size == 7)
    check(cookies.filter { it.softBaked }.size == 3)
    check(cookies.groupBy { it.softBaked }[false]?.size == 4)
    check(abs(cookies.fold(0.0) { sum, cookie -> sum + cookie.price } - 10.83) < 0.000001)
    check(cookies.sortedBy { it.name }.first().name == "Banana Walnut")
    check(cookies.sortedBy { it.name }.last().name == "Vanilla Creme")
    println("All solution checks passed.")
}
