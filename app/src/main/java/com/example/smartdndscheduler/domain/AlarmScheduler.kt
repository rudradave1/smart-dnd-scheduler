package com.example.smartdndscheduler.domain

import androidx.compose.runtime.Composable
import com.example.smartdndscheduler.alarm.AlarmReceiver
import com.example.smartdndscheduler.data.model.DndSchedule
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock

object AlarmScheduler {
    fun scheduleAlarm(context: Context, schedule: DndSchedule) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("schedule_id", schedule.id)
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context, schedule.id.hashCode(), intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val triggerTime = SystemClock.elapsedRealtime() + 10_000 // Example delay
        alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent)
    }
}