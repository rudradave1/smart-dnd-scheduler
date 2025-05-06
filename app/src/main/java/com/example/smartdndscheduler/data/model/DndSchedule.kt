package com.example.smartdndscheduler.data.model

import java.util.UUID

data class DndSchedule(
    val id: String = UUID.randomUUID().toString(),
    val hour: Int,
    val minute: Int,
    val days: List<Int>, // 1=Sunday .. 7=Saturday
    val isActive: Boolean = true
)