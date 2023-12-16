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
    val event1 = Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", Daypart.EVENING, 15)
    println(event1)
}