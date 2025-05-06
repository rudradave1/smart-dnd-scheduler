package com.example.smartdndscheduler.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartdndscheduler.ui.screens.AddEditScheduleScreen
import com.example.smartdndscheduler.ui.screens.HomeScreen
import com.example.smartdndscheduler.ui.screens.PermissionScreen
import com.example.smartdndscheduler.ui.screens.SplashScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Permission : Screen("permission")
    object Home : Screen("home")
    object AddEditSchedule : Screen("add_edit")
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Permission.route) { PermissionScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.AddEditSchedule.route) { AddEditScheduleScreen(navController) }
    }
}
