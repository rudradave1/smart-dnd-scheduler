package com.example.smartdndscheduler.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartdndscheduler.domain.DndManager
import com.example.smartdndscheduler.navigation.Screen

@Composable
fun PermissionScreen(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "We need DND permission to automate silent mode.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            DndManager.requestDndPermission(context)
        }) {
            Text("Open DND Settings")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (DndManager.hasDndPermission(context)) navController.navigate(Screen.Home.route)
        }) {
            Text("Continue")
        }
    }
}