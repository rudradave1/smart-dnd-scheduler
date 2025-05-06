package com.example.smartdndscheduler.util

fun formatTime(hour: Int, minute: Int): String {
    val amPm = if (hour < 12) "AM" else "PM"
    val hour12 = if (hour == 0 || hour == 12) 12 else hour % 12
    return "%02d:%02d %s".format(hour12, minute, amPm)
}
