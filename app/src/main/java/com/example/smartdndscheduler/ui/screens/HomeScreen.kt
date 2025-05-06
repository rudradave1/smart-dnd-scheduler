package com.example.smartdndscheduler.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartdndscheduler.data.model.DndSchedule
import com.example.smartdndscheduler.data.store.ScheduleDataStore
import com.example.smartdndscheduler.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var schedules by remember { mutableStateOf<List<DndSchedule>>(emptyList()) }

    LaunchedEffect(Unit) {
        ScheduleDataStore.getSchedules(context).collect {
            schedules = it
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddEditSchedule.route)
            }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            Text("Your DND Schedules", style = MaterialTheme.typography.headlineSmall)
            schedules.forEach {
                Text("${it.hour}:${it.minute} on ${it.days}")
            }
        }
    }
}
