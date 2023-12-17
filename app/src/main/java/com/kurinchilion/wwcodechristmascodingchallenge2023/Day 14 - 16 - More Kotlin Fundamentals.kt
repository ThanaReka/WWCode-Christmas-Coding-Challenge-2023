package com.kurinchilion.wwcodechristmascodingchallenge2023


enum class Daypart {
    MORNING, AFTERNOON, EVENING
}
data class Event(
    val title: String,
    val description: String?,
    val daypart: Daypart,
    val durationInMinutes: Int
)

val events = mutableListOf(
    Event(
        title = "Wake up",
        description = "Time to get up",
        daypart = Daypart.MORNING,
        durationInMinutes = 0
    ),
    Event(
        title = "Eat breakfast",
        description = "",
        daypart = Daypart.MORNING,
        durationInMinutes = 15
    ),
    Event(
        title = "Learn about Kotlin",
        description = "",
        daypart = Daypart.AFTERNOON,
        durationInMinutes = 30
    ),
    Event(
        title = "Practice Compose",
        description = "",
        daypart = Daypart.AFTERNOON,
        durationInMinutes = 60
    ),
    Event(
        title = "Watch latest DevBytes video",
        description = "",
        daypart = Daypart.AFTERNOON,
        durationInMinutes = 10
    ),
    Event(
        title = "Check out latest Android Jetpack library",
        description = "",
        daypart = Daypart.EVENING,
        durationInMinutes = 45
    )
)

fun main() {
    val shortEvents = events.filter {
        it.durationInMinutes < 60
    }

    val morningEvents = events.filter{
        it.daypart == Daypart.MORNING
    }

    val afternoonEvents = events.filter{
        it.daypart == Daypart.AFTERNOON
    }

    val eveningEvents = events.filter{
        it.daypart == Daypart.EVENING
    }

    val durationOfEvent = if (events[0].durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

    println("You have ${shortEvents.size} events.\n")

    println("Morning: ${morningEvents.size} events")

    println("Afternoon: ${afternoonEvents.size} events")

    println("Evening: ${eveningEvents.size} events")

    println("Last event of the day: ${events.last().title}")

    println("Duration of first event of the day: $durationOfEvent")

}