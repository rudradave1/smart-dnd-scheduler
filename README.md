# smart-dnd-scheduler
⏰ Smart DND Scheduler -> Automate Silent Mode on Your Android Device

This Jetpack Compose Android app lets users schedule silent/DND mode automatically on selected days and times. Designed for productivity, meetings, and deep work.

## ✅ Features Implemented
- Splash, Permission, Home, and Add/Edit Schedule screens
- Navigation using NavHostController
- DND access permission management
- Persistent schedule storage using DataStore and Gson
- AlarmManager integration to trigger DND at correct time
  
## Limitations

- Does not handle device reboot persistence yet
- Relies on AlarmManager (no WorkManager fallback)
---

Built using **Jetpack Compose**, **Kotlin**, and modern Android practices. Ideal starter app to learn background task automation and permission handling.
