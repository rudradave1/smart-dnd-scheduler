package com.example.smartdndscheduler.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartdndscheduler.data.model.DndSchedule
import com.example.smartdndscheduler.data.store.ScheduleDataStore
import com.example.smartdndscheduler.domain.AlarmScheduler
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

@Composable
fun AddEditScheduleScreen(navController: NavHostController) {
    var hour by remember { mutableStateOf(9) }
    var minute by remember { mutableStateOf(0) }
    var selectedDays by remember { mutableStateOf(listOf(1, 2, 3, 4, 5)) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Set Time", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text("Hour: $hour")
            Spacer(Modifier.width(8.dp))
            Text("Minute: $minute")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val schedule = DndSchedule(hour = hour, minute = minute, days = selectedDays)
            scope.launch {
                val current = ScheduleDataStore.getSchedules(context).first()
                ScheduleDataStore.saveSchedules(context, current + schedule)
                AlarmScheduler.scheduleAlarm(context, schedule)
                navController.popBackStack()
            }
        }) {
            Text("Save Schedule")
        }
    }
}